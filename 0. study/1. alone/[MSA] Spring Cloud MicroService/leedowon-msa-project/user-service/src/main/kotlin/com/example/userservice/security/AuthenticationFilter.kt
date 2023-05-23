package com.example.userservice.security

import com.example.userservice.application.UserService
import com.example.userservice.dto.LoginRequest
import com.example.userservice.infrastructure.UserQuery
import com.fasterxml.jackson.databind.ObjectMapper
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import mu.KotlinLogging
import org.springframework.core.env.Environment
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.ObjectPostProcessor
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.stereotype.Component
import java.io.IOException
import java.util.*
import javax.crypto.SecretKey

@Component
class AuthenticationFilter(
    private val objectPostProcessor: ObjectPostProcessor<Any>,
    private val userDetailServiceImpl: UserService,
    private val bCryptPasswordEncoder: BCryptPasswordEncoder,
    private val objectMapper: ObjectMapper,
    private val userQuery: UserQuery,
    private val env: Environment
) : UsernamePasswordAuthenticationFilter() {

    private val log = KotlinLogging.logger {}

    init {
        authenticationManager = createAuthenticationManager()
    }

    @Throws(AuthenticationException::class)
    override fun attemptAuthentication(request: HttpServletRequest, response: HttpServletResponse): Authentication {

        return try {

            val credentials: LoginRequest = objectMapper.readValue(request.inputStream, LoginRequest::class.java)
            val authenticationToken = usernamePasswordAuthenticationToken(credentials)
            // id, pw 비교하는 로직 위임
            val authenticate: Authentication = authenticationManager.authenticate(authenticationToken)

            authenticate

        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }

    // 인증 성공 후처리 로직
    override fun successfulAuthentication(
        request: HttpServletRequest,
        response: HttpServletResponse,
        chain: FilterChain,
        authResult: Authentication
    ) {

        val username = (authResult.principal as SecurityUser).username
        log.info("User Name : $username")
        val userId = userQuery.findIdByUsername(username)
        val expirationTime = createExpirationDateTime()
        val key = createKey()
        val algorithm = SignatureAlgorithm.HS512

        val token = createToken(userId, expirationTime, key, algorithm)

        response.addHeader("token", token)
        response.addHeader("userId", userId.toString())
    }

    @Throws(Exception::class)
    private fun createAuthenticationManager(): AuthenticationManager {

        val authenticationManagerBuilder = AuthenticationManagerBuilder(objectPostProcessor)

        authenticationManagerBuilder.userDetailsService<UserDetailsService>(userDetailServiceImpl).passwordEncoder(bCryptPasswordEncoder)

        return authenticationManagerBuilder.build()
    }

    private fun createToken(
        userId: Long,
        expirationTime: Date,
        key: SecretKey,
        algorithm: SignatureAlgorithm
    ): String? =
        Jwts.builder()
            .setSubject(userId.toString())
            .setExpiration(expirationTime)
            .signWith(key, algorithm)
            .compact()

    private fun createKey(): SecretKey {

        val secretKey = env.getProperty("token.secret")!!

        return Keys.hmacShaKeyFor(secretKey.toByteArray())
    }

    private fun createExpirationDateTime(): Date =
        Date(System.currentTimeMillis() + env.getProperty("token.expiration-time")!!.toLong())

    private fun usernamePasswordAuthenticationToken(credentials: LoginRequest) =
        UsernamePasswordAuthenticationToken(credentials.email, credentials.password, emptyList())
}
package com.example.userservice.security

import com.example.userservice.dto.LoginRequest
import com.example.userservice.service.UserService
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import lombok.extern.slf4j.Slf4j
import org.springframework.core.env.Environment
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.stereotype.Component
import java.io.IOException


class AuthenticationFilter(private val objectMapper: ObjectMapper) : UsernamePasswordAuthenticationFilter() {

    @Throws(AuthenticationException::class)
    override fun attemptAuthentication(request: HttpServletRequest, response: HttpServletResponse): Authentication {

        return try {
            val credentials: LoginRequest = objectMapper.readValue(request.inputStream, LoginRequest::class.java)
            val authenticationToken = usernamePasswordAuthenticationToken(credentials)
            // id, pw 비교 위임
            val authenticate: Authentication = authenticationManager.authenticate(authenticationToken)

            authenticate
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }

    // 인증 성공 후처리 로직
    override fun successfulAuthentication(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        chain: FilterChain?,
        authResult: Authentication?
    ) {
        // TODO: .
    }

    private fun usernamePasswordAuthenticationToken(credentials: LoginRequest) =
        UsernamePasswordAuthenticationToken(credentials.email, credentials.password, emptyList())
}
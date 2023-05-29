package com.example.apigatewayservice.filter

import com.example.apigatewayservice.filter.AuthorizationHeaderFilter.*
import io.jsonwebtoken.Jwts
import mu.KotlinLogging
import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.GatewayFilterChain
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.http.HttpStatus
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.http.server.reactive.ServerHttpResponse
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono
import javax.crypto.SecretKey

private const val AUTHORIZATION = "AUTHORIZATION"

@Component
class AuthorizationHeaderFilter(
    private val secretKey: SecretKey
) : AbstractGatewayFilterFactory<Config>(Config::class.java) {

    class Config

    private val log = KotlinLogging.logger {}

    override fun apply(config: Config?): GatewayFilter =
        GatewayFilter { exchange: ServerWebExchange,
                        chain: GatewayFilterChain ->

            val request: ServerHttpRequest = exchange.request
            if (!request.headers.containsKey(AUTHORIZATION)) {
                return@GatewayFilter onUnAuthorizedError(exchange, "No authorization header")
            }
            val authorizationHeader: String = parseAuthorizationHeader(request)
            val jwt = extractJwt(authorizationHeader)

            // todo 해당 토큰 값이 실제 사용자인지 확인하는 로직이 있어야 함
            if (isTokenValid(jwt).not()) {
                return@GatewayFilter onUnAuthorizedError(exchange, "JWT token is not valid")
            }
            chain.filter(exchange)
        }

    private fun parseAuthorizationHeader(request: ServerHttpRequest): String =
        request.headers[AUTHORIZATION]!![0]

    private fun extractJwt(authorizationHeader: String) = authorizationHeader.replace("Bearer", "").trim()

    private fun onUnAuthorizedError(exchange: ServerWebExchange, errorMessage: String): Mono<Void> {

        val response: ServerHttpResponse = exchange.response
        response.statusCode = HttpStatus.UNAUTHORIZED

        log.error(errorMessage)

        return response.setComplete()
    }


    private fun isTokenValid(jwt: String): Boolean {

        val tokenBody: String? = parseToken(jwt)

        if (tokenBody.isNullOrEmpty()) {
            return false
        }

        return true
    }

    private fun parseToken(jwt: String): String? =
        try {
            Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(jwt)
                .body
                .subject
        } catch (ex: Exception) {
            ""
        }
}
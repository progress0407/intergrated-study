package com.example.apigatewayservice.filter

import com.google.common.net.HttpHeaders
import io.jsonwebtoken.Jwts
import org.hibernate.query.sqm.tree.SqmNode.log
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

@Component
class AuthorizationHeaderFilter(
    private val secretKey: SecretKey
) : AbstractGatewayFilterFactory<AuthorizationHeaderFilter.Config>(Config::class.java) {

    class Config

    override fun apply(config: Config?): GatewayFilter =
        GatewayFilter { exchange: ServerWebExchange,
                        chain: GatewayFilterChain ->

            val request: ServerHttpRequest = exchange.request
            if (!request.headers.containsKey(HttpHeaders.AUTHORIZATION)) {
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
        request.headers[HttpHeaders.AUTHORIZATION]!![0]

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
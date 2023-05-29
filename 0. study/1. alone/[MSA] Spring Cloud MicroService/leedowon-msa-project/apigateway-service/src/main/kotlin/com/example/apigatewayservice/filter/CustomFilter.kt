package com.example.apigatewayservice.filter

import com.example.apigatewayservice.filter.CustomFilter.*
import org.slf4j.LoggerFactory
import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.GatewayFilterChain
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.http.server.reactive.ServerHttpResponse
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

@Component
class CustomFilter() : AbstractGatewayFilterFactory<Config>(Config::class.java) {

    private val log = LoggerFactory.getLogger(CustomFilter::class.java)

    override fun apply(config: Config?): GatewayFilter =
        GatewayFilter { exchange: ServerWebExchange,
                        chain: GatewayFilterChain ->

            val request: ServerHttpRequest = exchange.request
            val response: ServerHttpResponse = exchange.response

            log.info("custom Pre filter: request id: {}", request.id)

            chain
                .filter(exchange)
                .then(Mono.fromRunnable {
                    log.info("custom Post filter: request id: {}", response.statusCode)
                })
        }

    class Config {
        // put the configuration properties if exist
    }
}

package com.example.apigatewayservice.filter

import com.example.apigatewayservice.filter.GlobalFilter.*
import org.slf4j.LoggerFactory
import org.springframework.cloud.gateway.filter.GatewayFilter
import org.springframework.cloud.gateway.filter.GatewayFilterChain
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

@Component
class GlobalFilter : AbstractGatewayFilterFactory<Config>(Config::class.java) {

    val log = LoggerFactory.getLogger(GlobalFilter::class.java)!!

    override fun apply(config: Config?): GatewayFilter =
        GatewayFilter { exchange: ServerWebExchange,
                        chain: GatewayFilterChain ->

            if (config == null) {
                throw NullPointerException("config should not be null")
            }

            log.info("Global Filter baseMessage: {}", config.baseMessage)

            if (config.preLogger) {
                log.info("Global Filter Start: request id -> {}", exchange.request.id)
            }

            chain
                .filter(exchange)
                .then(Mono.fromRunnable {
                    if (config.postLogger) {
                        log.info("Global Filter End: request id -> {}", exchange.response.statusCode)
                    }
                })
        }

    class Config {
        lateinit var baseMessage: String
        var preLogger: Boolean = false
        var postLogger: Boolean = false
    }
}

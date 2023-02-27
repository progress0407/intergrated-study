package com.example.apigatewayservice.config

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.cloud.gateway.route.builder.routes
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

//@Configuration
class FilterConfig {

//    @Bean
    fun gatewayRoutes(builder: RouteLocatorBuilder): RouteLocator =
        builder.routes {
            route {
                path("/first-service/**")
                    .filters {
                        it
                            .addRequestHeader("first-request", "first-request-value")
                            .addResponseHeader("first-response", "first-response-value")
                    }
                    .uri("http://localhost:8081")
            }
            route {
                path("/second-service/**")
                    .filters {
                        it
                            .addRequestHeader("second-request", "second-request-value")
                            .addResponseHeader("second-response", "second-response-value")
                    }
                    .uri("http://localhost:8082")
            }
        }
}

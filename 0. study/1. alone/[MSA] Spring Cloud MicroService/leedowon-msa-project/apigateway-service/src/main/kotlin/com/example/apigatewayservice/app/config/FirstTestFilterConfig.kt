package com.example.apigatewayservice.app.config

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.cloud.gateway.route.builder.routes

/**
 * API Gateway 첫 실습때 사용한 테스트용 Bean Config 클래스
 */

//@Configuration
class FirstTestFilterConfig {

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

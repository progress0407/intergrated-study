package com.example.apigatewayservice.app.config

import org.springframework.boot.actuate.web.exchanges.HttpExchangeRepository
import org.springframework.boot.actuate.web.exchanges.InMemoryHttpExchangeRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringActuatorConfig {

    @Bean
    fun httpExchangeRepository(): HttpExchangeRepository = InMemoryHttpExchangeRepository()
}
package com.example.userservice.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class UserAppConfig {

    @Bean
    fun restTemplate() = RestTemplate()
}
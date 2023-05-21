package com.example.userservice.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
class SecuritySecondaryConfiguration {

    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder()
}
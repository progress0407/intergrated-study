package com.example.apigatewayservice.config

import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.crypto.SecretKey

@Configuration
class SecuritySecondaryConfiguration(
    @Value("\${token.secret-key}") private val secretKey: String
) {

    @Bean
    fun secretKey(): SecretKey = Keys.hmacShaKeyFor(secretKey.toByteArray())
}
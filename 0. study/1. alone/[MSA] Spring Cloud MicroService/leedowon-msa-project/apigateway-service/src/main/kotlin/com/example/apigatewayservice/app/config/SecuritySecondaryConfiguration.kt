package com.example.apigatewayservice.app.config

import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import javax.crypto.SecretKey

@Configuration
class SecuritySecondaryConfiguration(
    @Value("\${token.secret-key}") private val secretKey: String,
    private val environment: Environment // for debug
) {

    @Bean
    fun secretKey(): SecretKey {
        return Keys.hmacShaKeyFor(secretKey.toByteArray())
    }
}
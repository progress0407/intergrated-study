package com.example.configservice.app.presentation

import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/config-service")
@RestController
class ConfigServiceController(val env: Environment) {

    @GetMapping("/app-info")
    fun status() =
        """
        It's Config Service
        port(local.server.port) = ${env.getProperty("local.server.port")}, 
        port(server.port) = ${env.getProperty("server.port")}, 
        token secret key = ${env.getProperty("token.secret-key")}, 
        token expiration duration time = ${env.getProperty("token.expiration-duration-time")}
        """.trimIndent()
}
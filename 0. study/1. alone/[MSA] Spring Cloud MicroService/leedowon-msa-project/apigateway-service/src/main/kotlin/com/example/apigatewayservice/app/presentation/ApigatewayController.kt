package com.example.apigatewayservice.app.presentation

import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/gateway")
@RestController
class ApigatewayController(val env: Environment) {

    @GetMapping("/app-info")
    fun appInfo() =
        """
        It's API Gateway
        port(local.server.port) = ${env.getProperty("local.server.port")}, 
        port(server.port) = ${env.getProperty("server.port")}, 
        token secret key = ${env.getProperty("token.secret-key")}, 
        token expiration duration time = ${env.getProperty("token.expiration-duration-time")}
        """.trimIndent()
}
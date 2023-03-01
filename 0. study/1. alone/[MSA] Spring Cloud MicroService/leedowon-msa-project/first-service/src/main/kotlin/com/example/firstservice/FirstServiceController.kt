package com.example.firstservice

import jakarta.servlet.http.HttpServletRequest
import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/first-service")
@Slf4j
class FirstServiceController(val env: Environment) {

    private val log = LoggerFactory.getLogger(FirstServiceController::class.java)

    @GetMapping("/welcome")
    fun welcome() = "Welcome to the First service."

    @GetMapping("/message")
    fun message(@RequestHeader("first-request") header: String): String {

        log.info(header)

        return "Hello World to the First service."
    }

    @GetMapping("/check")
    fun check(request: HttpServletRequest): String {

        log.info("Server Port: ${request.serverPort}")

        return "Hi, there. This is a message from First Service on PORT ${env.getProperty("local.server.port")}"
    }
}

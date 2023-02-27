package com.example.secondservice

import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/second-service")
@Slf4j
class SecondServiceController {

    private val log = LoggerFactory.getLogger(SecondServiceController::class.java)

    @GetMapping("/welcome")
    fun welcome() = "Welcome to the Second service."

    @GetMapping("/message")
    fun message(@RequestHeader("second-request") header: String): String {

        log.info(header)

        return "Hello World to the Second service."
    }
}

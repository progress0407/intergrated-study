package com.example.userservice.controller

import com.example.userservice.dto.CreateUserRequest
import com.example.userservice.dto.CreateUserResponse
import com.example.userservice.service.UserService
import com.example.userservice.vo.Greeting
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user-service")
class UserController(
    val env: Environment,
    val greeting: Greeting,
    val userService: UserService
) {

    @GetMapping("/health_check")
    fun status() = "It's Working in User Service"

    @GetMapping("/welcome")
    fun welcome(): String {
//        return env.getProperty("greeting.message") ?: "No Message"
        return greeting.message
    }

    @PostMapping
    fun createUser(@RequestBody createUserRequest: CreateUserRequest): CreateUserResponse {
        return userService.createUser(createUserRequest)
    }
}
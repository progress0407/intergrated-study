package com.example.userservice.presentation

import com.example.userservice.dto.CreateUserRequest
import com.example.userservice.dto.CreateUserResponse
import com.example.userservice.dto.UserResponse
import com.example.userservice.infrastructure.UserQuery
import com.example.userservice.application.UserService
import com.example.userservice.vo.Greeting
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.*


@RequestMapping("/users")
@RestController
class UserController(
    val env: Environment,
    val greeting: Greeting,
    val userService: UserService,
    val userQuery: UserQuery) {

    @GetMapping("/health_check")
    fun status() =
        """
        It's Working in User Service 
        port(local.server.port)= ${env.getProperty("local.server.port")}
        """.trimIndent()

    @GetMapping("/welcome")
    fun welcome(): String {
//        return env.getProperty("greeting.message") ?: "No Message"
        return greeting.message
    }

    @PostMapping
    fun createUser(@RequestBody createUserRequest: CreateUserRequest): CreateUserResponse {
        return userService.createUser(createUserRequest)
    }

    @GetMapping
    fun findAll(): List<UserResponse> {
        return userQuery.findAll()
    }

    @GetMapping("/{userId}")
    fun findByUserId(@PathVariable("userId") userId: Long): UserResponse {
        return userQuery.findOne(userId)
    }
}
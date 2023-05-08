package com.example.userservice.infrastructure

import com.example.userservice.dto.UserResponse
import com.example.userservice.exception.UserNotFoundException
import org.springframework.stereotype.Component

@Component
class UserQuery(private val userRepository: UserRepository) {

    fun findAll(): List<UserResponse> =
        userRepository.findAll()
            .map { UserResponse(it) }
            .toList()

    fun findOne(userId: Long): UserResponse {

        val userOne = userRepository.findById(userId).orElseThrow { throw UserNotFoundException("User not found") }
        return UserResponse(userOne, listOf())
    }
}
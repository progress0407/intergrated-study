package com.example.userservice.service

import com.example.userservice.dto.CreateUserRequest
import com.example.userservice.dto.CreateUserResponse
import com.example.userservice.entity.User
import com.example.userservice.repository.UserRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val userRepository: UserRepository,
                  private val passwordEncoder: BCryptPasswordEncoder) {

    fun createUser(dto: CreateUserRequest): CreateUserResponse {
        val user = createUserOne(dto)
        userRepository.save(user)
        return CreateUserResponse(user.id!!, user.userId)
    }

    private fun createUserOne(dto: CreateUserRequest): User {
        val randomId = createRandomId()
        val encodedPassword = passwordEncoder.encode(dto.password)
        return User(
            userId = randomId,
            email = dto.email,
            name = dto.name,
            encryptedPassword = encodedPassword
        )
    }

    private fun createRandomId() = UUID.randomUUID().toString()
}
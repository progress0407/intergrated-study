package com.example.userservice.application

import com.example.userservice.dto.CreateUserRequest
import com.example.userservice.dto.CreateUserResponse
import com.example.userservice.domain.User
import com.example.userservice.infrastructure.UserRepository
import com.example.userservice.security.SecurityUser
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: BCryptPasswordEncoder
) : UserDetailsService {

    fun createUser(dto: CreateUserRequest): CreateUserResponse {

        val user = createUserFromDto(dto)
        userRepository.save(user)

        return CreateUserResponse(user.id)
    }

    override fun loadUserByUsername(username: String): UserDetails {

        val user = userRepository.findByEmail(username) ?: throw UsernameNotFoundException(username)

        return SecurityUser(
            username = user.email,
            password = user.encryptedPassword,
            authorities = emptyList<GrantedAuthority>()
        )
    }

    private fun createUserFromDto(dto: CreateUserRequest): User {

        val randomId = createRandomId()
        val encodedPassword = passwordEncoder.encode(dto.password)

        return User(
            id = randomId,
            email = dto.email,
            name = dto.name,
            encryptedPassword = encodedPassword
        )
    }
    private fun createRandomId() = UUID.randomUUID().toString()
}

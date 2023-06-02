package com.example.userservice.infrastructure

import com.example.userservice.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, String> {

    fun findByEmail(email: String): User?
}
package com.example.userservice.infrastructure

import com.example.userservice.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long>
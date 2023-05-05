package com.example.userservice.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class CreateUserRequest(

    @NotNull(message = "Email cannot be null")
    @Size(min = 2, message = "Email not be less than two characters")
    @Email
    val email: String = "",

    @NotNull(message = "Name cannot be null")
    @Size(min = 2, message = "Name not be less than two characters")
    val name: String = "",

    @NotNull(message = "Password  cannot be null")
    @Size(min = 2, message = "Password must be equal or grater than 8 characters")
    val password: String = ""
)
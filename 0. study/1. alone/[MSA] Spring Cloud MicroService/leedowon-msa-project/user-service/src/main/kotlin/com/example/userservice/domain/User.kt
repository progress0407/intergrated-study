package com.example.userservice.domain

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "users")
open class User(

    @Id
    @Column(nullable = false, unique = true)
    open var id: String,

    @Column(nullable = false, length = 50, unique = true)
    open var email: String,

    @Column(nullable = false, length = 50)
    open var name: String,

    @Column(nullable = false)
    open var encryptedPassword: String
) {
    constructor() : this(id = "", email = "", name = "", encryptedPassword = "")

    override fun toString(): String {
        return "User(id='$id', email='$email', name='$name', encryptedPassword='$encryptedPassword')"
    }

    private fun createRandomId() = UUID.randomUUID().toString()
}
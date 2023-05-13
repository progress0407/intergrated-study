package com.example.userservice.entity

import jakarta.persistence.*
import lombok.ToString

@Entity
@Table(name = "users")
open class User(

    @Column(nullable = false, length = 50, unique = true)
    open var email: String,

    @Column(nullable = false, length = 50)
    open var name: String,

    @Column(nullable = false, unique = true)
    open var userId: String,

    @Column(nullable = false, unique = true)
    open var encryptedPassword: String
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long? = null

    constructor() : this(email = "", name = "", userId = "", encryptedPassword = "")

    override fun toString(): String {
        return "User(email='$email', name='$name', userId='$userId', encryptedPassword='$encryptedPassword', id=$id)"
    }
}
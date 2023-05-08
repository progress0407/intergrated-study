package com.example.userservice.dto

import com.example.userservice.entity.User

//@JsonInclude(JsonInclude.Include.NON_NULL)
class UserResponse(user: User, val orderResponses: List<OrderResponse>) {

    constructor(user: User) : this(user, listOf())
    constructor(): this(User())

    var email: String
        private set
    var name: String
        private set
    var userId: String
        private set

    init {
        this.email = user.email
        this.name = user.name
        this.userId = user.userId
    }
}
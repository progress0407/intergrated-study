package com.example.userservice.dto

import com.example.userservice.domain.User

//@JsonInclude(JsonInclude.Include.NON_NULL)
class UserResponse(user: User, val orderResponses: List<OrderResponse>?) {

    var userId: String
        private set
    var email: String
        private set

    var name: String
        private set

    constructor(): this(User())
    constructor(user: User) : this(user, listOf())

    init {
        this.email = user.email
        this.name = user.name
        this.userId = user.id
    }
}


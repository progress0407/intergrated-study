package com.example.userservice.dto

import java.time.LocalDate

data class OrderResponse(
    val orderId: String,
    val productId: String,
    val qty: Int,
    val unitPrice: Int,
    val totalPrice: Int,
    val createdAt: LocalDate
)
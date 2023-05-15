package org.example.order.app

import java.time.LocalDateTime

data class OrderResponse(

    val orderId: String = "",

    val productId: String = "",

    val unitPrice: Int = 0,

    val orderQuantity: Int = 0,

    val totalPrice: Int = 0,

    val createdAt: LocalDateTime = LocalDateTime.now()
)

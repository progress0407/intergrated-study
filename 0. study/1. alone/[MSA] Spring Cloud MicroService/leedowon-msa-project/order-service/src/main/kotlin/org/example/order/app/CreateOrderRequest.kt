package org.example.order.app

import jakarta.validation.constraints.NotNull

data class CreateOrderRequest(

    @NotNull
    private val productId: String = "",

    @NotNull
    private val orderQuantity: Int = 0,

    @NotNull
    private val unitPrice: Int = 0
) {

    fun toEntity(userId: String): Order {
        return Order(userId, productId, orderQuantity, unitPrice)
    }
}
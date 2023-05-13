package org.example.order.app

import lombok.Data

@Data
class CreateOrderRequest {

    private val productId: String? = null
    private val orderQuantity: Int? = null
    private val unitPrice: Int? = null

    fun toEntity(userId: String): Order {
        return Order(userId, productId!!, orderQuantity!!, unitPrice!!)
    }
}
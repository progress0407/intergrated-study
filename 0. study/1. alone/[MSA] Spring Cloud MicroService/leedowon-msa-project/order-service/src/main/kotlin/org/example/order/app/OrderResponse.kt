package org.example.order.app

import java.time.LocalDateTime

//@JsonInclude(JsonInclude.Include.NON_NULL)
class OrderResponse {

    private val orderId: String? = null
    private val productId: String? = null
    private val unitPrice: Int? = null
    private val orderQuantity: Int? = null
    private val totalPrice: Int? = null
    private val createdAt: LocalDateTime? = null

    constructor()
}
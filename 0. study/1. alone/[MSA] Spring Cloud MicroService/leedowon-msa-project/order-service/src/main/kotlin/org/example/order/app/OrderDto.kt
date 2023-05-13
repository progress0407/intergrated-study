package org.example.order.app

import lombok.Data
import java.io.Serializable


@Data
class OrderDto : Serializable {
    private val productId: String? = null
    private val qty: Int? = null
    private val unitPrice: Int? = null
    private val totalPrice: Int? = null
    private val orderId: String? = null
    private val userId: String? = null
}
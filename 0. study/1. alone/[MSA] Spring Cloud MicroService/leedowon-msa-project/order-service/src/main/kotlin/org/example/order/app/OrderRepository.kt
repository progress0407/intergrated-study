package org.example.order.app

import org.springframework.data.repository.CrudRepository


interface OrderRepository : CrudRepository<Order, Long> {

    fun findByOrderId(orderId: String): Order

    fun findByUserId(userId: String): Iterable<Order>

}
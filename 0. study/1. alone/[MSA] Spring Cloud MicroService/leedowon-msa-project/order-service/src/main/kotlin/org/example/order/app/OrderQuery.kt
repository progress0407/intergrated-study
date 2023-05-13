package org.example.order.app

import org.modelmapper.ModelMapper
import org.modelmapper.convention.MatchingStrategies
import org.springframework.stereotype.Component

@Component
class OrderQuery(private val orderRepository: OrderRepository) {

    private val converter = ModelMapper()

    init {
        converter.configuration.matchingStrategy = MatchingStrategies.STRICT
    }

    fun finderOrdersByUserId(userId: String): List<OrderResponse> {

        val orders: Iterable<Order> = orderRepository.findByUserId(userId)
        val orderResponses = orders.map { convertDto(it) }.toList()

        return orderResponses
    }

    private fun convertDto(order: Order): OrderResponse {

        val orderResponse = OrderResponse()
        converter.map(order, orderResponse)

        return orderResponse
    }
}
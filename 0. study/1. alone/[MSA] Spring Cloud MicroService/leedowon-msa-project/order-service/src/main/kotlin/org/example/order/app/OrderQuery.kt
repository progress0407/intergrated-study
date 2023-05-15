package org.example.order.app

import org.modelmapper.ModelMapper
import org.modelmapper.config.Configuration
import org.modelmapper.convention.MatchingStrategies
import org.springframework.stereotype.Component

@Component
class OrderQuery(private val orderRepository: OrderRepository) {

    private val converter = ModelMapper()

    init {
        val configuration = converter.configuration
        configuration.matchingStrategy = MatchingStrategies.STRICT

        // setter 없이 매핑 가능하게 함
        configuration.fieldAccessLevel = Configuration.AccessLevel.PRIVATE
        configuration.isFieldMatchingEnabled = true
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
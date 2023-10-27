package org.example.order.app

import org.modelmapper.ModelMapper
import org.modelmapper.convention.MatchingStrategies
import org.springframework.stereotype.Service


@Service
class OrderService(private val orderRepository: OrderRepository) {

    private val converter = ModelMapper()

    init {
        converter.configuration.matchingStrategy = MatchingStrategies.STRICT
    }

    fun createOrder(createOrderRequest: CreateOrderRequest, userId: String): OrderResponse {
        val order: Order = createOrderRequest.toEntity(userId)
        orderRepository.save(order)
        val orderResponse = OrderResponse()
        converter.map(order, orderResponse)
        return orderResponse
    }
}
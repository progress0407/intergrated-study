package com.example.userservice.infrastructure

import com.example.userservice.dto.OrderResponse
import com.example.userservice.dto.UserResponse
import com.example.userservice.entity.User
import com.example.userservice.exception.UserNotFoundException
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod.GET
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import java.lang.RuntimeException

@Component
class UserQuery(private val userRepository: UserRepository,
                private val restTemplate: RestTemplate) {

    fun findAll(): List<UserResponse> {

        return userRepository.findAll()
            .map { UserResponse(it) }
            .toList()
    }

    fun findOne(userId: Long): UserResponse {

        val userOne: User = userRepository.findById(userId).orElseThrow { throw UserNotFoundException("User not found") }

        val orderResponses = getOrdersFromOrderService(userId).body ?: throw RuntimeException("Order Service로부터 응답을 받지 못했습니다.")

        return UserResponse(userOne, orderResponses)
    }

    private fun getOrdersFromOrderService(userId: Long): ResponseEntity<List<OrderResponse>> {

        val orderServiceUrl = "http://localhost:8000/order-service/${userId}/orders"

        return restTemplate.exchange(orderServiceUrl, GET, null, responseType())
    }

    private fun responseType() = object : ParameterizedTypeReference<List<OrderResponse>>() {}

    fun findIdByUsername(username: String): Long {
        val user = userRepository.findByEmail(username) ?: throw UserNotFoundException("User not found")
        return user.id!!
    }
}
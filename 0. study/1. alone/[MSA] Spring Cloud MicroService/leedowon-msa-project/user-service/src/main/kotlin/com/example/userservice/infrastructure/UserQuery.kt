package com.example.userservice.infrastructure

import com.example.userservice.dto.OrderResponse
import com.example.userservice.dto.UserResponse
import com.example.userservice.domain.User
import com.example.userservice.exception.UserNotFoundException
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod.GET
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class UserQuery(
    private val userRepository: UserRepository,
    private val restTemplate: RestTemplate,
    @Value("\${order-service-url-format}") private val orderServiceUrlFormat: String
) {

    fun findAll(): List<UserResponse> {

        return userRepository.findAll()
            .map { UserResponse(it) }
            .toList()
    }

    fun findOne(userId: String): UserResponse {

        val userOne: User =
            userRepository.findById(userId).orElseThrow { throw UserNotFoundException() }

        val orderResponses = requestOrdersFromOrderService(userId)

        return UserResponse(userOne, orderResponses)
    }

    private fun requestOrdersFromOrderService(userId: String): List<OrderResponse>? {

        val orderServiceUrl = orderServiceUrlFormat.format(userId)

        val response =
            try {
                restTemplate.exchange(orderServiceUrl, GET, null, responseType())
            } catch (ex: Exception) {
                null
            }

        return response?.body
    }

    private fun responseType() = object : ParameterizedTypeReference<List<OrderResponse>>() {}

    fun findIdByUsername(username: String): String {

        val user = userRepository.findByEmail(username) ?: throw UserNotFoundException()

        return user.id
    }
}
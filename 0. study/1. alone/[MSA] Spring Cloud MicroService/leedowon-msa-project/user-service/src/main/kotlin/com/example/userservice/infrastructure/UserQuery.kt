package com.example.userservice.infrastructure

import com.example.userservice.dto.OrderResponse
import com.example.userservice.dto.UserResponse
import com.example.userservice.domain.User
import com.example.userservice.exception.UserNotFoundException
import com.example.userservice.httpclient.OrderServiceClient
import feign.FeignException
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod.GET
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class UserQuery(
    private val userRepository: UserRepository,
    private val restTemplate: RestTemplate,
    @Value("\${order-service-url-format}") private val orderServiceUrlFormat: String,
    private val orderServiceClient: OrderServiceClient
) {

    private val log = KotlinLogging.logger {  }

    fun findAll(): List<UserResponse> {

        return userRepository.findAll()
            .map { UserResponse(it) }
            .toList()
    }

    fun findOne(userId: String): UserResponse {

        val userOne: User =
            userRepository.findById(userId).orElseThrow { throw UserNotFoundException() }

        // RestTemplate + Try Catch
//        val orderResponses = requestOrdersFromOrderServiceByRestTemplate(userId)

        // Open Feign Client + Try Catch
        val orderResponses = requestOrdersFromOrderServiceByFeignClient(userId)

        // Open Feign Client + Error Decoder of Open Feign
        val orderResponses2 = orderServiceClient.requestWrongOrders(userId)

        return UserResponse(userOne, orderResponses)
    }

    private fun requestOrdersFromOrderServiceByFeignClient(userId: String): List<OrderResponse>? =

        try {
            orderServiceClient.requestOrders(userId)
        } catch (ex: FeignException) {
            log.error { ex.message }
            null
        }

    private fun requestOrdersFromOrderServiceByRestTemplate(userId: String): List<OrderResponse>? {

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
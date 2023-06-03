package com.example

import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.web.client.RestTemplate
import java.time.LocalDate
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

private const val URL = "http://localhost:8000/order-service/d715865d-edd6-4ef9-ad0e-eaa0d23f64ed/orders"

fun main() {

    val restTemplate = RestTemplate()

    val exchange = restTemplate.exchange(URL, HttpMethod.GET, null, responseType())

    val body = exchange.body

    println("body = ${body}")
}

private fun responseType() = object : ParameterizedTypeReference<List<OrderResponse>>() {}

data class OrderResponse(
    val orderId: String,
    val productId: String,
    val qty: Int,
    val unitPrice: Int,
    val totalPrice: Int,
    val createdAt: LocalDate
)
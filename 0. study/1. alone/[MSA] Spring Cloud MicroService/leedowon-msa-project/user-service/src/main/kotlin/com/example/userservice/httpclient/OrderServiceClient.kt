package com.example.userservice.httpclient

import com.example.userservice.dto.OrderResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(name = "order-service")
interface OrderServiceClient {

    @GetMapping("/order-service/{userId}/orders")
    fun requestOrders(@PathVariable userId: String): List<OrderResponse>?

    /**
     * Test용도, 잘못된 주소
     */
    @GetMapping("/order-service/{userId}/orders_ng")
    fun requestWrongOrders(@PathVariable userId: String): List<OrderResponse>?
}
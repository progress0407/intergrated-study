package org.example.order.app

import lombok.extern.slf4j.Slf4j
import org.hibernate.query.sqm.tree.SqmNode.log
import org.springframework.core.env.Environment
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/order-service")
@Slf4j
class OrderController(private val environment: Environment,
                      private val orderService: OrderService,
                      private val orderQuery: OrderQuery) {

    @GetMapping("/health_check")
    fun status(): String {
        return "It's Working in Order Service on PORT ${environment.getProperty("local.server.port")}"
    }

    @PostMapping("/{userId}/orders")
    @ResponseStatus(HttpStatus.CREATED)
    fun createOrder(@PathVariable userId: String,
                    @RequestBody createOrderRequest: CreateOrderRequest): OrderResponse {

        log.info("Before add orders data")
        val orderResponse = orderService.createOrder(createOrderRequest, userId)
        log.info("After added orders data")

        return orderResponse
    }

    @GetMapping("/{userId}/orders")
    @Throws(Exception::class)
    fun getOrder(@PathVariable userId: String): List<OrderResponse> {

        log.info("Before retrieve orders data")

        val orderResponses = orderQuery.finderOrdersByUserId(userId)
//        delayOrException()

        log.info("Add retrieved orders data")

        return orderResponses
    }

    private fun delayOrException() {
        try {
            Thread.sleep(1000)
            throw Exception("장애 발생")
        } catch (ex: InterruptedException) {
            log.warn(ex.message)
        }
    }
}
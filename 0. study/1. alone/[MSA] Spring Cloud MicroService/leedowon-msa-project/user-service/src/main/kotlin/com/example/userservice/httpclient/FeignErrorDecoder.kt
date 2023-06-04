package com.example.userservice.httpclient

import feign.Response
import feign.codec.ErrorDecoder
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class FeignErrorDecoder : ErrorDecoder {

    override fun decode(methodKey: String, response: Response): Exception? {
        val exception = when (val statusCode: Int = response.status()) {
            400 -> null
            404 -> if (methodKey.contains("requestWrongOrders") || methodKey.contains("requestOrders")) {
                ResponseStatusException(HttpStatus.valueOf(statusCode), "User's orders is empty!")
            } else null

            else -> Exception(response.reason())
        }
        return exception
    }
}
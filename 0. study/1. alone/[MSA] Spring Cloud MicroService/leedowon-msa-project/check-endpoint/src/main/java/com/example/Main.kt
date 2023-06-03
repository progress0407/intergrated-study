package com.example

import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod.POST
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.client.RestTemplate
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

private const val LOGIN_ENDPOINT = "http://localhost:8000/user-service/login"

fun main() {
    val response = retrieveToken()
    println("Access Token: $response")
}

fun retrieveToken(): Any? {
    // Create RestTemplate instance
    val restTemplate = RestTemplate()

    // Set the request headers
    val headers = setRequestHeaders()

    // Set the request body parameters
    val requestBody = setRequestBodyParams()

    // Create the HTTP entity with headers and body
    val requestEntity = HttpEntity(requestBody, headers)

    // Send the POST request
    val responseEntity =
        restTemplate.exchange(
            LOGIN_ENDPOINT,
            POST,
            requestEntity,
            JvmType.Object::class.java
        )

    // Check if the request was successful
    return if (responseEntity.statusCode === HttpStatus.OK) {
            responseEntity.body
    } else {
        throw RuntimeException("Failed to retrieve token. Status code: " + responseEntity.statusCode)
    }
}

private fun setRequestHeaders(): HttpHeaders {
    val headers = HttpHeaders()
    headers.contentType = MediaType.APPLICATION_JSON
    return headers
}

private fun setRequestBodyParams(): HashMap<String, String> {

    val requestBody = HashMap<String, String>()
    requestBody["email"] = "hello@google.com"
    requestBody["password"] = "1234"

    return requestBody
}
package com.example.userservice.config

import com.example.userservice.httpclient.FeignErrorDecoder
import feign.Logger
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class UserAppConfig {

    @LoadBalanced
    @Bean
    fun restTemplate() = RestTemplate()

    @Bean
    fun feignLoggerLevel(): Logger.Level = Logger.Level.FULL

    @Bean
    fun feignErrorDecoder() = FeignErrorDecoder()

}
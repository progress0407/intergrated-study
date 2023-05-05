package com.example.userservice.security

import org.springframework.boot.autoconfigure.security.servlet.PathRequest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain


@EnableWebSecurity
@Configuration
class SecurityConfiguration {

    companion object {
        private val WHITE_LIST = arrayOf("/users/**", "/**")
    }

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain =
        http.csrf().disable()
            .headers().frameOptions().disable().and()
            .authorizeHttpRequests {
                it.requestMatchers(*WHITE_LIST).permitAll()
//                    .requestMatchers(PathRequest.toH2Console()).permitAll()
            }.build()

    @Bean
    fun  passwordEncoder() = BCryptPasswordEncoder()
}
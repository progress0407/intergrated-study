package com.example.userservice.security

import com.example.userservice.application.UserService
import com.example.userservice.infrastructure.UserQuery
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.ObjectPostProcessor
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain


@EnableWebSecurity
@Configuration
class SecurityConfiguration(
    private val authenticationFilter: AuthenticationFilter
) {

    companion object {
        private val WHITE_LIST = arrayOf("/users/**", "/**")
    }

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {

        return http.csrf().disable()
            .headers().frameOptions().disable().and()
            .addFilter(authenticationFilter)
            .authorizeHttpRequests {
                it.requestMatchers(*WHITE_LIST).permitAll()
//                    .requestMatchers(PathRequest.toH2Console()).permitAll()
            }.build()
    }
}
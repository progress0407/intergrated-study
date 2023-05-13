package org.example.catalog.app

import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RequestMapping("/catalog-service")
@RestController
class CatalogController(private val env: Environment,
                        private val categoryQuery: CategoryQuery
) {

    @GetMapping("/health_check")
    fun status(): String {

        return "It's Working in Catalog Service on PORT  ${ env.getProperty("local.server.port") }"
    }

    @GetMapping("/catalogs")
    fun findAll(): List<CatalogResponse> {

        return categoryQuery.findAll()
    }
}
package org.example.catalog.app

import org.springframework.stereotype.Component

@Component
class CategoryQuery(private val cateRepository: CatalogRepository) {

    fun findAll(): List<CatalogResponse> {
        return cateRepository.findAll()
            .map { CatalogResponse(it) }
            .toList()
    }
}
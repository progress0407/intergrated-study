package org.example.catalog.app

import org.springframework.data.jpa.repository.JpaRepository

interface CatalogRepository: JpaRepository<CatalogEntity, Long> {
}
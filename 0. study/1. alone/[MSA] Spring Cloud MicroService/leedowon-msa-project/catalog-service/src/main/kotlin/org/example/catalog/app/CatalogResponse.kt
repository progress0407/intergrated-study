package org.example.catalog.app

import java.time.LocalDateTime

//@JsonInclude(JsonInclude.Include.NON_NULL)
class CatalogResponse {

    var productId: String? = null
        private set

    var productName: String? = null
        private set

    var unitPrice: Int? = null
        private set

    var stock: Int? = null
        private set

    var createdAt: LocalDateTime? = null
        private set

    constructor(entity: CatalogEntity) {
        this.productId = entity.productId
        this.productName = entity.productName
        this.unitPrice = entity.unitPrice
        this.stock = entity.stock
        this.createdAt = entity.createdAt
    }
}
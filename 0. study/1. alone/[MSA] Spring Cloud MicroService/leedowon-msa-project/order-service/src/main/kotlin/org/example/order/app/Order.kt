package org.example.order.app

import jakarta.persistence.*
import lombok.Data
import org.hibernate.annotations.ColumnDefault
import java.time.LocalDateTime
import java.util.UUID


@Entity
@Table(name = "orders")
open class Order {
    
    @Id
    open var id: Long? = null

    @Column(nullable = false, length = 120, unique = true)
    open var productId: String? = null

    @Column(nullable = false)
    open var orderQuantity: Int? = null

    @Column(nullable = false)
    open var unitPrice: Int? = null

    @Column(nullable = false)
    open var totalPrice: Int? = null

    @Column(nullable = false)
    open var userId: String? = null

    @Column(nullable = false, unique = true)
    open var orderId: String? = null

    @Column(nullable = false, updatable = false, insertable = false)
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    open var createdAt: LocalDateTime? = null

    constructor()

    constructor(userId: String, productId: String, unitPrice: Int, orderQuantity: Int) {
        this.orderId = UUID.randomUUID().toString()
        this.productId = productId
        this.userId = userId
        this.unitPrice = unitPrice
        this.orderQuantity = orderQuantity
    }
}
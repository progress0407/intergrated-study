package org.example.catalog.app

import jakarta.persistence.*
import org.hibernate.annotations.ColumnDefault
import java.time.LocalDateTime


@Entity
@Table(name = "catalog")
open class Catalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open val id: Long? = null

    @Column(nullable = false, length = 120, unique = true)
    open val productId: String? = null

    @Column(nullable = false)
    open val productName: String? = null

    @Column(nullable = false)
    open val stock: Int? = null

    @Column(nullable = false)
    open val unitPrice: Int? = null

    @Column(nullable = false, updatable = false, insertable = false)
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    open val createdAt: LocalDateTime? = null
}
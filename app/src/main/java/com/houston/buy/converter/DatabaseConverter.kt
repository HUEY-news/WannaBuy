package com.houston.buy.converter

import com.houston.buy.data.db.ProductEntity
import com.houston.buy.domain.model.Product

class DatabaseConverter {
    fun map(product: Product) = ProductEntity(
        id = product.id,
        name = product.name,
        description = product.description
    )

    fun map(entity: ProductEntity) = Product(
        id = entity.id,
        name = entity.name,
        description = entity.description
    )
}

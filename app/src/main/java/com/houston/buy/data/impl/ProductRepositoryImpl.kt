package com.houston.buy.data.impl

import com.houston.buy.converter.DatabaseConverter
import com.houston.buy.data.db.ProductDatabase
import com.houston.buy.domain.api.ProductRepository
import com.houston.buy.domain.model.Product

class ProductRepositoryImpl(
    private val database: ProductDatabase,
    private val converter: DatabaseConverter
) : ProductRepository {

    override suspend fun addProduct(product: Product) {
        val entity = converter.map(product)
        database.productDao().addProduct(entity)
    }

    override suspend fun removeProduct(product: Product) {
        val entity = converter.map(product)
        database.productDao().removeProduct(entity)
    }
}
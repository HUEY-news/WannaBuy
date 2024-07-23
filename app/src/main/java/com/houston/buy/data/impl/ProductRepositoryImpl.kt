package com.houston.buy.data.impl

import android.net.Uri
import com.houston.buy.converter.DatabaseConverter
import com.houston.buy.data.db.ProductDatabase
import com.houston.buy.data.db.ProductEntity
import com.houston.buy.domain.api.ProductRepository
import com.houston.buy.domain.model.Product

class ProductRepositoryImpl(
    private val database: ProductDatabase,
    private val converter: DatabaseConverter
) : ProductRepository {

    override suspend fun addProduct(id: String?, name: String, description: String?, image: Uri?) {
        val entity = ProductEntity(
            id = id,
            name = name,
            description = description,
            image = image.toString()
        )
        database.productDao().addProduct(entity)
    }

    override suspend fun removeProduct(product: Product) {
        val entity = converter.map(product)
        database.productDao().removeProduct(entity)
    }
}

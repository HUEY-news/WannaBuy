package com.houston.buy.data.impl

import android.net.Uri
import com.houston.buy.converter.DatabaseConverter
import com.houston.buy.data.db.ProductDatabase
import com.houston.buy.data.db.ProductEntity
import com.houston.buy.domain.api.ProductRepository
import com.houston.buy.domain.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProductRepositoryImpl(
    private val database: ProductDatabase,
    private val converter: DatabaseConverter
) : ProductRepository {

    override fun getProductList(): Flow<List<Product>> = flow {
        val entityList = database.productDao().getItemList()
        val productList = convertFromEntity(entityList.sortedByDescending { entity: ProductEntity -> entity.addingTime })
        emit(productList)
    }

    private fun convertFromEntity(entityList: List<ProductEntity>): List<Product> {
        return entityList.map { entity: ProductEntity -> converter.map(entity) }
    }

    override suspend fun createNewProduct(name: String, description: String?, image: Uri?) {
        val product = Product(name = name, description = description, image = image.toString())
        val entity = converter.map(product)
        database.productDao().addItemToList(entity)
    }

    override suspend fun removeProduct(id: Int) {
        database.productDao().removeItemFromList(id)
    }
}

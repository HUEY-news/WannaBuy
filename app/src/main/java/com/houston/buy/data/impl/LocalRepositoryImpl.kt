package com.houston.buy.data.impl

import android.net.Uri
import com.houston.buy.converter.Converter
import com.houston.buy.data.db.Database
import com.houston.buy.data.db.Entity
import com.houston.buy.domain.api.LocalRepository
import com.houston.buy.domain.model.Data
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    private val database: Database,
    private val converter: Converter
) : LocalRepository {

    override fun getProductList(): Flow<List<Data>> = flow {
        val entityList = database.dao().getItemList()
        val productList = convertFromEntity(entityList.sortedBy { entity: Entity -> entity.name })
        emit(productList)
    }

    private fun convertFromEntity(entityList: List<Entity>): List<Data> {
        return entityList.map { entity: Entity -> converter.map(entity) }
    }

    override suspend fun createNewProduct(name: String, description: String, image: Uri?) {
        val data = Data(name = name, description = description, image = image.toString())
        val entity = converter.map(data)
        database.dao().save(entity)
    }

    override suspend fun removeProduct(id: Int) {
        database.dao().delete(id)
    }
}
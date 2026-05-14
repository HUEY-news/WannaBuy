package com.houston.buy.converter

import com.houston.buy.data.db.Entity
import com.houston.buy.domain.model.Data

class Converter {
    fun map(data: Data) = Entity(
        id = data.id,
        name = data.name,
        description = data.description,
        image = data.image,
        addingTime = System.currentTimeMillis()
    )

    fun map(entity: Entity) = Data(
        id = entity.id,
        name = entity.name,
        description = entity.description,
        image = entity.image
    )
}
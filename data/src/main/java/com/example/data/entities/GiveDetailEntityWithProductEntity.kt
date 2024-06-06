package com.example.data.entities

import androidx.room.Embedded
import androidx.room.Relation

data class GiveDetailEntityWithProductEntity(
    @Embedded val giveDetailEntity: GiveDetailEntity,
    @Relation(
        parentColumn = "IdProduct",
        entityColumn = "IdProduct"
    )
    val productEntity: ProductEntity
)
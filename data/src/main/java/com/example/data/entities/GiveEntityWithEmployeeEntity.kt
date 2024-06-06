package com.example.data.entities

import androidx.room.Embedded
import androidx.room.Relation

data class GiveEntityWithEmployeeEntity(
    @Embedded val giveEntity: GiveEntity,
    @Relation(
        parentColumn = "IdEmployee",
        entityColumn = "IdEmployee"
    )
    val employee: EmployeeEntity
)
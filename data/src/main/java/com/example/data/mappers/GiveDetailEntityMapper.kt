package com.example.data.mappers

import com.example.data.entities.GiveDetailEntity
import com.example.domain.entities.GiveDetailParam

class GiveDetailEntityMapper {

    fun mapToGiveDetailEntity(giveDetailParam : GiveDetailParam) : GiveDetailEntity
    {
        return GiveDetailEntity(
            Id = giveDetailParam.Id,
            IdGive = giveDetailParam.IdGive,
            IdProduct = giveDetailParam.IdProduct,
            CountProduct = giveDetailParam.CountProduct)
    }

    fun mapToGiveDetailParam(giveDetailEntity : GiveDetailEntity) : GiveDetailParam
    {
        return GiveDetailParam(
            Id = giveDetailEntity.Id,
            IdGive = giveDetailEntity.IdGive,
            IdProduct = giveDetailEntity.IdProduct,
            CountProduct = giveDetailEntity.CountProduct)
    }
}
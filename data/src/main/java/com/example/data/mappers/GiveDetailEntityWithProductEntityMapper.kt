package com.example.data.mappers

import com.example.data.entities.GiveDetailEntityWithProductEntity
import com.example.data.entities.GiveEntityWithEmployeeEntity
import com.example.domain.entities.GiveDetailParamWithProductParam
import com.example.domain.entities.GiveParamWithEmployeeParam

class GiveDetailEntityWithProductEntityMapper(private val giveDetailEntityMapper : GiveDetailEntityMapper, private val productEntityMapper: ProductEntityMapper) {

    fun mapToGiveDetailEntityWithProductEntity(giveDetailParam : GiveDetailParamWithProductParam) : GiveDetailEntityWithProductEntity
    {
        return GiveDetailEntityWithProductEntity(
            giveDetailEntity = giveDetailEntityMapper.mapToGiveDetailEntity(giveDetailParam.giveDetail),
            productEntity = productEntityMapper.mapToProductEntity(giveDetailParam.product)
        )
    }


    fun mapToGiveDetailParamWithProductParam(giveDetailEntity : GiveDetailEntityWithProductEntity) : GiveDetailParamWithProductParam
    {
        return GiveDetailParamWithProductParam(
            giveDetail = giveDetailEntityMapper.mapToGiveDetailParam(giveDetailEntity.giveDetailEntity),
            product = productEntityMapper.mapToProductParam(giveDetailEntity.productEntity)
        )
    }
}
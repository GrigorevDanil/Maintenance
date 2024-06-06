package com.example.maintenance.presentation.mappers

import com.example.domain.entities.GiveDetailParamWithProductParam
import com.example.domain.entities.GiveParamWithEmployeeParam
import com.example.maintenance.presentation.entity.GiveDetailWithProduct
import com.example.maintenance.presentation.entity.GiveWithEmployee

class GiveDetailWithProductMapper(private val giveDetailMapper: GiveDetailMapper, private val productMapper: ProductMapper) {

    fun mapGiveDetailParamWithProductParamListToGiveDetailWithProductList(listGiveDetailParamWithProductParam : List<GiveDetailParamWithProductParam>) :List<GiveDetailWithProduct>
    {
        val gives = arrayListOf<GiveDetailWithProduct>()
        for (giveDetailParam in listGiveDetailParamWithProductParam) {

            gives.add(
                GiveDetailWithProduct(
                    giveDetail = giveDetailMapper.mapGiveDetailParamToGiveDetail(giveDetailParam.giveDetail),
                    product = productMapper.mapProductParamToProduct(giveDetailParam.product)
                )
            )
        }
        return gives.sortedBy { item -> item.giveDetail.Id}
    }

    fun mapGiveDetailWithProductToGiveDetailParamWithProductParam(giveDetail : GiveDetailWithProduct) : GiveDetailParamWithProductParam
    {
        return GiveDetailParamWithProductParam(
            giveDetail = giveDetailMapper.mapGiveDetailToGiveDetailParam(giveDetail.giveDetail),
            product = productMapper.mapProductToProductParam(giveDetail.product)
        )
    }
}
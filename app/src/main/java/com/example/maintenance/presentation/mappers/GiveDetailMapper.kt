package com.example.maintenance.presentation.mappers

import com.example.domain.entities.GiveDetailParam
import com.example.domain.entities.ProductParam
import com.example.maintenance.presentation.entity.GiveDetail
import com.example.maintenance.presentation.entity.Product

class GiveDetailMapper {

    fun mapGiveDetailParamListToGiveList(listGiveParam : List<GiveDetailParam>) :List<GiveDetail>
    {
        val giveDetails = arrayListOf<GiveDetail>()
        for (giveDetailParam in listGiveParam) {

            giveDetails.add(
                GiveDetail(
                    Id = giveDetailParam.Id,
                    IdGive = giveDetailParam.IdGive,
                    IdProduct = giveDetailParam.IdProduct,
                    CountProduct = giveDetailParam.CountProduct)
            )
        }
        return giveDetails.sortedBy { it.Id }
    }

    fun mapGiveDetailParamToGiveDetail(giveDetailParam : GiveDetailParam) : GiveDetail
    {
        return GiveDetail(
            Id = giveDetailParam.Id,
            IdGive = giveDetailParam.IdGive,
            IdProduct = giveDetailParam.IdProduct,
            CountProduct = giveDetailParam.CountProduct)
    }

    fun mapGiveDetailToGiveDetailParam(giveDetail : GiveDetail) : GiveDetailParam
    {
        return GiveDetailParam(
            Id = giveDetail.Id,
            IdGive = giveDetail.IdGive,
            IdProduct = giveDetail.IdProduct,
            CountProduct = giveDetail.CountProduct)
    }
}
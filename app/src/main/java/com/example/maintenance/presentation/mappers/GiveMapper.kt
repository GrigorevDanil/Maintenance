package com.example.maintenance.presentation.mappers

import com.example.domain.entities.GiveParam
import com.example.domain.entities.GiveParamWithEmployeeParam
import com.example.maintenance.presentation.entity.Give

class GiveMapper {

    fun mapGiveParamListToGiveList(listGiveParam : List<GiveParam>) :List<Give>
    {
        val gives = arrayListOf<Give>()
        for (giveParam in listGiveParam) {

            gives.add(
                Give(
                    Id = giveParam.Id,
                    IdEmployee = giveParam.IdEmployee,
                    DateGive = giveParam.DateGive)
            )
        }
        return gives.sortedBy { it.Id }
    }

    fun mapGiveParamToGive(giveParam : GiveParam) : Give
    {
        return Give(
            Id = giveParam.Id,
            IdEmployee = giveParam.IdEmployee,
            DateGive = giveParam.DateGive)
    }

    fun mapGiveToGiveParam(give : Give) : GiveParam
    {
        return GiveParam(
            Id = give.Id,
            IdEmployee = give.IdEmployee,
            DateGive = give.DateGive)
    }
}
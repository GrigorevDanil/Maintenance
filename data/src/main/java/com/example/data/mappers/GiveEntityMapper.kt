package com.example.data.mappers

import com.example.data.entities.GiveEntity
import com.example.data.entities.GiveEntityWithEmployeeEntity
import com.example.domain.entities.GiveParam
import com.example.domain.entities.GiveParamWithEmployeeParam
import java.text.SimpleDateFormat

class GiveEntityMapper {

    fun mapToGiveEntity(giveParam : GiveParam) : GiveEntity
    {
        return GiveEntity(
            Id = giveParam.Id,
            IdEmployee = giveParam.IdEmployee,
            DateGive = SimpleDateFormat("yyyy-MM-dd").format(giveParam.DateGive)
        )
    }


    fun mapToGiveParam(giveEntity : GiveEntity) : GiveParam
    {
        return GiveParam(
            Id = giveEntity.Id,
            IdEmployee = giveEntity.IdEmployee,
            DateGive = SimpleDateFormat("yyyy-MM-dd").parse(giveEntity.DateGive)
        )
    }
}
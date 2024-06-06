package com.example.data.mappers

import com.example.data.entities.GiveEntity
import com.example.data.entities.GiveEntityWithEmployeeEntity
import com.example.domain.entities.GiveParam
import com.example.domain.entities.GiveParamWithEmployeeParam
import java.text.SimpleDateFormat

class GiveEntityWithEmployeeEntityMapper(private val giveEntityMapper : GiveEntityMapper, private val employeeEntityMapper: EmployeeEntityMapper) {

    fun mapToGiveEntityWithEmployeeEntity(giveParam : GiveParamWithEmployeeParam) : GiveEntityWithEmployeeEntity
    {
        return GiveEntityWithEmployeeEntity(
            giveEntity = giveEntityMapper.mapToGiveEntity(giveParam.give),
            employee =  employeeEntityMapper.mapToEmployeeEntity(giveParam.employee)
        )
    }


    fun mapToGiveParamWithEmployeeParam(giveEntity : GiveEntityWithEmployeeEntity) : GiveParamWithEmployeeParam
    {
        return GiveParamWithEmployeeParam(
            give = giveEntityMapper.mapToGiveParam(giveEntity.giveEntity),
            employee = employeeEntityMapper.mapToEmployeeParam(giveEntity.employee)
        )
    }
}
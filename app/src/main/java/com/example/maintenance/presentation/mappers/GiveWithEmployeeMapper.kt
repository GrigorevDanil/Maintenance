package com.example.maintenance.presentation.mappers

import com.example.domain.entities.GiveParam
import com.example.domain.entities.GiveParamWithEmployeeParam
import com.example.maintenance.presentation.entity.Give
import com.example.maintenance.presentation.entity.GiveWithEmployee

class GiveWithEmployeeMapper(private val giveMapper: GiveMapper, private val employeeMapper: EmployeeMapper) {

    fun mapGiveParamListToGiveList(listGiveParamWithEmployeeParam : List<GiveParamWithEmployeeParam>) :List<GiveWithEmployee>
    {
        val gives = arrayListOf<GiveWithEmployee>()
        for (giveParam in listGiveParamWithEmployeeParam) {

            gives.add(
                GiveWithEmployee(
                        give = giveMapper.mapGiveParamToGive(giveParam.give),
                        employee = employeeMapper.mapEmployeeParamToEmployee(giveParam.employee)
                )
            )
        }
        return gives.sortedBy { item -> item.give.Id}
    }

    fun mapGiveWithEmployeeToGiveParamWithEmployeeParam(give : GiveWithEmployee) : GiveParamWithEmployeeParam
    {
        return GiveParamWithEmployeeParam(
        give = giveMapper.mapGiveToGiveParam(give.give),
            employee = employeeMapper.mapEmployeeToEmployeeParam(give.employee)
        )
    }
}
package com.example.data.mappers

import com.example.data.entities.EmployeeEntity
import com.example.domain.entities.EmployeeParam

class EmployeeEntityMapper {

    fun mapToEmployeeEntity(empParam : EmployeeParam) : EmployeeEntity
    {
        return EmployeeEntity(
            Id = empParam.Id,
            Post = empParam.Post,
            Surname =  empParam.Surname,
            Name = empParam.Name,
            Lastname = empParam.Lastname,
            NumPhone = empParam.NumPhone,
            Address = empParam.Address)
    }

    fun mapToEmployeeParam(empEnitity : EmployeeEntity) : EmployeeParam
    {
        return EmployeeParam(
            Id = empEnitity.Id,
            Post = empEnitity.Post,
            Surname =  empEnitity.Surname,
            Name = empEnitity.Name,
            Lastname = empEnitity.Lastname,
            NumPhone = empEnitity.NumPhone,
            Address = empEnitity.Address)
    }
}
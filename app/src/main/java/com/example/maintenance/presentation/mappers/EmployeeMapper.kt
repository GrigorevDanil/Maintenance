package com.example.maintenance.presentation.mappers

import com.example.domain.entities.EmployeeParam
import com.example.domain.entities.ProductParam
import com.example.maintenance.presentation.entity.Employee
import com.example.maintenance.presentation.entity.Product

class EmployeeMapper {

    fun mapEmployeeParamListToEmployeeList(listEmployeeParam : List<EmployeeParam>) :List<Employee>
    {
        val employees = arrayListOf<Employee>()
        for (employeeParam in listEmployeeParam) {

            employees.add(
                Employee(
                    Id = employeeParam.Id,
                    Post = employeeParam.Post,
                    Surname = employeeParam.Surname,
                    Name = employeeParam.Name,
                    Lastname = employeeParam.Lastname,
                    NumPhone = employeeParam.NumPhone,
                    Address = employeeParam.Address)
            )
        }
        return employees.sortedBy { it.Id }
    }

    fun mapEmployeeParamToEmployee(employeeParam : EmployeeParam) : Employee
    {
        return Employee(
            Id = employeeParam.Id,
            Post = employeeParam.Post,
            Surname = employeeParam.Surname,
            Name = employeeParam.Name,
            Lastname = employeeParam.Lastname,
            NumPhone = employeeParam.NumPhone,
            Address = employeeParam.Address)
    }

    fun mapEmployeeToEmployeeParam(employee : Employee) : EmployeeParam
    {
        return EmployeeParam(
            Id = employee.Id,
            Post = employee.Post,
            Surname = employee.Surname,
            Name = employee.Name,
            Lastname = employee.Lastname,
            NumPhone = employee.NumPhone,
            Address = employee.Address)
    }

}
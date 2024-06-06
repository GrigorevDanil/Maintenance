package com.example.domain.repositories

import com.example.domain.entities.EmployeeParam
import kotlinx.coroutines.flow.Flow

interface IEmployeeRepository {

    suspend fun getEmployees() : Flow<List<EmployeeParam>>

    suspend fun addEmployee(param : EmployeeParam)

    suspend fun updateEmployee(param : EmployeeParam)

    suspend fun deleteEmployee(param : EmployeeParam)
}
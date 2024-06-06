package com.example.data.repository.employee

import com.example.domain.entities.EmployeeParam
import kotlinx.coroutines.flow.Flow

interface IEmployeeLocalDataSource {

    suspend fun getEmployees() : Flow<List<EmployeeParam>>

    suspend fun addEmployee(param : EmployeeParam)

    suspend fun updateEmployee(param : EmployeeParam)

    suspend fun deleteEmployee(param : EmployeeParam)
}
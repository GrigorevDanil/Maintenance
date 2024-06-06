package com.example.data.repository.employee

import com.example.domain.entities.EmployeeParam
import com.example.domain.repositories.IEmployeeRepository
import kotlinx.coroutines.flow.Flow

class EmployeeRepositoryImpl(
    private val localDataSource : IEmployeeLocalDataSource
) : IEmployeeRepository{

    override suspend fun getEmployees(): Flow<List<EmployeeParam>> = localDataSource.getEmployees()

    override suspend fun addEmployee(param: EmployeeParam) = localDataSource.addEmployee(param)

    override suspend fun updateEmployee(param: EmployeeParam) = localDataSource.updateEmployee(param)

    override suspend fun deleteEmployee(param: EmployeeParam) = localDataSource.deleteEmployee(param)

}
package com.example.data.repository.employee

import com.example.data.db.dao.EmployeeDao
import com.example.data.mappers.EmployeeEntityMapper
import com.example.domain.entities.EmployeeParam
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class EmployeeLocalDataSourceImpl
    (
    private val empDao : EmployeeDao,
    private val dispatcher: CoroutineDispatcher,
    private val empMapper: EmployeeEntityMapper
) : IEmployeeLocalDataSource {

    override suspend fun getEmployees(): Flow<List<EmployeeParam>> {
        val employees = empDao.getEmployees()
        return employees.map { list ->
            list.map { element ->
                empMapper.mapToEmployeeParam(element)
            }
        }
    }

    override suspend fun addEmployee(param: EmployeeParam) = withContext(dispatcher){
        empDao.createEmployee(empMapper.mapToEmployeeEntity(param))
    }

    override suspend fun updateEmployee(param: EmployeeParam) {
        empDao.updateEmployee(empMapper.mapToEmployeeEntity(param))
    }

    override suspend fun deleteEmployee(param : EmployeeParam) = withContext(dispatcher){
        empDao.deleteEmployee(empMapper.mapToEmployeeEntity(param))
    }

}
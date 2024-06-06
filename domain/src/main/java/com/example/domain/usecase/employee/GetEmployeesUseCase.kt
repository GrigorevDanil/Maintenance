package com.example.domain.usecase.employee

import com.example.domain.entities.EmployeeParam
import com.example.domain.repositories.IEmployeeRepository

class GetEmployeesUseCase(private val empRepository : IEmployeeRepository) {
    suspend operator fun invoke() = empRepository.getEmployees()
}
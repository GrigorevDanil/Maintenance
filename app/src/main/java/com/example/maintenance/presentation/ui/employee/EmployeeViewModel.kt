package com.example.maintenance.presentation.ui.employee

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.employee.CreateEmployeeUseCase
import com.example.domain.usecase.employee.DeleteEmployeeUseCase
import com.example.domain.usecase.employee.GetEmployeesUseCase
import com.example.domain.usecase.employee.UpdateEmployeeUseCase
import com.example.domain.usecase.product.CreateProductUseCase
import com.example.domain.usecase.product.DeleteProductUseCase
import com.example.domain.usecase.product.GetProductsUseCase
import com.example.domain.usecase.product.UpdateProductUseCase
import com.example.maintenance.presentation.entity.Employee
import com.example.maintenance.presentation.entity.Product
import com.example.maintenance.presentation.mappers.EmployeeMapper
import com.example.maintenance.presentation.mappers.ProductMapper
import kotlinx.coroutines.launch

class EmployeeViewModel(
    private val createEmployeeUseCase: CreateEmployeeUseCase,
    private val updateEmployeeUseCase: UpdateEmployeeUseCase,
    private val deleteEmployeeUseCase: DeleteEmployeeUseCase,
    private val getEmployeeUseCase: GetEmployeesUseCase,
    private val employeeMapper : EmployeeMapper
) : ViewModel() {

    private val _employees = MutableLiveData<List<Employee>>()
    val employees = _employees

    fun getEmployees() = viewModelScope.launch {
        getEmployeeUseCase.invoke()
            .collect { employeeList ->
                _employees.postValue(employeeMapper.mapEmployeeParamListToEmployeeList(employeeList))
            }
    }

    fun addEmployee(employee: Employee)= viewModelScope.launch {
        createEmployeeUseCase.invoke(employeeMapper.mapEmployeeToEmployeeParam(employee))
    }

    fun updateEmployee(employee: Employee)= viewModelScope.launch {
        updateEmployeeUseCase.invoke(employeeMapper.mapEmployeeToEmployeeParam(employee))
    }

    fun deleteEmployee(employee: Employee)= viewModelScope.launch {
        deleteEmployeeUseCase.invoke(employeeMapper.mapEmployeeToEmployeeParam(employee))
    }

}
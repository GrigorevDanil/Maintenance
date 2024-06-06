package com.example.maintenance.presentation.ui.give.dialog

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.employee.GetEmployeesUseCase
import com.example.domain.usecase.give.CreateGiveUseCase
import com.example.domain.usecase.give.DeleteGiveUseCase
import com.example.domain.usecase.give.GetGivesUseCase
import com.example.domain.usecase.give.UpdateGiveUseCase
import com.example.domain.usecase.givedetail.CreateGiveDetailUseCase
import com.example.domain.usecase.givedetail.DeleteGiveDetailsUseCase
import com.example.domain.usecase.givedetail.GetGiveDetailsUseCase
import com.example.domain.usecase.givedetail.UpdateGiveDetailsUseCase
import com.example.domain.usecase.product.GetProductsUseCase
import com.example.maintenance.presentation.entity.Employee
import com.example.maintenance.presentation.entity.GiveDetailWithProduct
import com.example.maintenance.presentation.entity.GiveWithEmployee
import com.example.maintenance.presentation.entity.Product
import com.example.maintenance.presentation.mappers.EmployeeMapper
import com.example.maintenance.presentation.mappers.GiveDetailWithProductMapper
import com.example.maintenance.presentation.mappers.GiveWithEmployeeMapper
import com.example.maintenance.presentation.mappers.ProductMapper
import kotlinx.coroutines.launch

class GiveDialogViewModel (
    private val getGivesDetailsUseCase: GetGiveDetailsUseCase,
    private val giveDetailWithProductMapper: GiveDetailWithProductMapper,
    private val getProductsUseCase: GetProductsUseCase,
    private val productMapper: ProductMapper,
    private val getEmployeesUseCase: GetEmployeesUseCase,
    private val employeeMapper: EmployeeMapper
) : ViewModel() {

    private val _newGiveDetails: MutableList<GiveDetailWithProduct> = mutableListOf()
    val newGiveDetails = _newGiveDetails

    private val _giveDetails = MutableLiveData<List<GiveDetailWithProduct>>()
    val giveDetails = _giveDetails

    private val _products = MutableLiveData<List<Product>>()
    val products = _products

    private val _employees = MutableLiveData<List<Employee>>()
    val employees = _employees

    fun getEmployees() = viewModelScope.launch {
        getEmployeesUseCase.invoke()
            .collect { employeeList ->
                _employees.postValue(employeeMapper.mapEmployeeParamListToEmployeeList(employeeList))
            }
    }

    fun getProducts() = viewModelScope.launch {
        getProductsUseCase.invoke()
            .collect { productList ->
                _products.postValue(productMapper.mapProductParamListToProductList(productList))
            }
    }

    fun getGiveDetails() = viewModelScope.launch {
        getGivesDetailsUseCase.invoke()
            .collect { giveList ->
                _giveDetails.postValue(giveDetailWithProductMapper.mapGiveDetailParamWithProductParamListToGiveDetailWithProductList(giveList))
            }
    }

    fun addGive(giveDetail: GiveDetailWithProduct)= viewModelScope.launch {
        _newGiveDetails.add(giveDetail)
        _giveDetails.postValue(_newGiveDetails.toList())
    }

    fun updateGive(giveDetail: GiveDetailWithProduct)= viewModelScope.launch {
        val index = _newGiveDetails.indexOfFirst { it.giveDetail.Id == giveDetail.giveDetail.Id }
        _newGiveDetails[index] = giveDetail
        _giveDetails.postValue(_newGiveDetails.toList())
    }

    fun deleteGive(giveDetail: GiveDetailWithProduct)= viewModelScope.launch {
        _newGiveDetails.remove(giveDetail)
        _giveDetails.postValue(_newGiveDetails.toList())
    }


}
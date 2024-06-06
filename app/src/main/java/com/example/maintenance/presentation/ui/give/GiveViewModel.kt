package com.example.maintenance.presentation.ui.give

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.GiveParamWithEmployeeParam
import com.example.domain.usecase.employee.GetEmployeesUseCase
import com.example.domain.usecase.give.CreateGiveUseCase
import com.example.domain.usecase.give.DeleteGiveUseCase
import com.example.domain.usecase.give.GetGivesUseCase
import com.example.domain.usecase.give.UpdateGiveUseCase
import com.example.domain.usecase.givedetail.CreateGiveDetailUseCase
import com.example.domain.usecase.givedetail.DeleteGiveDetailsUseCase
import com.example.domain.usecase.givedetail.UpdateGiveDetailsUseCase
import com.example.maintenance.presentation.entity.Employee
import com.example.maintenance.presentation.entity.GiveDetailWithProduct
import com.example.maintenance.presentation.entity.GiveWithEmployee
import com.example.maintenance.presentation.entity.Product
import com.example.maintenance.presentation.mappers.EmployeeMapper
import com.example.maintenance.presentation.mappers.GiveDetailWithProductMapper
import com.example.maintenance.presentation.mappers.GiveWithEmployeeMapper
import kotlinx.coroutines.launch

class GiveViewModel(
    private val createGiveUseCase: CreateGiveUseCase,
    private val updateGiveUseCase: UpdateGiveUseCase,
    private val deleteGiveUseCase: DeleteGiveUseCase,
    private val createGiveDetailUseCase: CreateGiveDetailUseCase,
    private val updateGiveDetailUseCase: UpdateGiveDetailsUseCase,
    private val deleteGiveDetailUseCase: DeleteGiveDetailsUseCase,
    private val getGivesUseCase: GetGivesUseCase,
    private val giveWithEmployeeMapper: GiveWithEmployeeMapper,
    private val giveDetailWithProductMapper: GiveDetailWithProductMapper
) : ViewModel() {

    private val _gives = MutableLiveData<List<GiveWithEmployee>>()
    val gives = _gives


    fun getGives() = viewModelScope.launch {
        getGivesUseCase.invoke()
            .collect { giveList ->
                _gives.postValue(giveWithEmployeeMapper.mapGiveParamListToGiveList(giveList))
            }
    }

    fun addGive(give: GiveWithEmployee)= viewModelScope.launch {
        createGiveUseCase.invoke(giveWithEmployeeMapper.mapGiveWithEmployeeToGiveParamWithEmployeeParam(give))
    }

    fun updateGive(give: GiveWithEmployee)= viewModelScope.launch {
        updateGiveUseCase.invoke(giveWithEmployeeMapper.mapGiveWithEmployeeToGiveParamWithEmployeeParam(give))
    }

    fun deleteGive(give: GiveWithEmployee)= viewModelScope.launch {
        deleteGiveUseCase.invoke(giveWithEmployeeMapper.mapGiveWithEmployeeToGiveParamWithEmployeeParam(give))
    }

    fun addGiveDetail(giveDetail: GiveDetailWithProduct)= viewModelScope.launch {
        createGiveDetailUseCase.invoke(giveDetailWithProductMapper.mapGiveDetailWithProductToGiveDetailParamWithProductParam(giveDetail))
    }

    fun updateGiveDetail(giveDetail: GiveDetailWithProduct)= viewModelScope.launch {
        updateGiveDetailUseCase.invoke(giveDetailWithProductMapper.mapGiveDetailWithProductToGiveDetailParamWithProductParam(giveDetail))
    }

    fun deleteGiveDetail(giveDetail: GiveDetailWithProduct)= viewModelScope.launch {
        deleteGiveDetailUseCase.invoke(giveDetailWithProductMapper.mapGiveDetailWithProductToGiveDetailParamWithProductParam(giveDetail))
    }



}
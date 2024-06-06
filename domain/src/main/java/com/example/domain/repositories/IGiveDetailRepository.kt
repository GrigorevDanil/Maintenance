package com.example.domain.repositories

import com.example.domain.entities.EmployeeParam
import com.example.domain.entities.GiveDetailParam
import com.example.domain.entities.GiveDetailParamWithProductParam
import kotlinx.coroutines.flow.Flow

interface IGiveDetailRepository {

    suspend fun getGiveDetails(idGive: Int) : Flow<List<GiveDetailParamWithProductParam>>

    suspend fun addGiveDetail(param : GiveDetailParamWithProductParam)

    suspend fun updateGiveDetail(param : GiveDetailParamWithProductParam)

    suspend fun deleteGiveDetail(param : GiveDetailParamWithProductParam)
}
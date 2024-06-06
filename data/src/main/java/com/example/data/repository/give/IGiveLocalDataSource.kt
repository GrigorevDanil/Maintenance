package com.example.data.repository.give

import com.example.domain.entities.GiveParamWithEmployeeParam
import kotlinx.coroutines.flow.Flow

interface IGiveLocalDataSource {

    suspend fun getGives() : Flow<List<GiveParamWithEmployeeParam>>

    suspend fun addGive(param : GiveParamWithEmployeeParam)

    suspend fun updateGive(param : GiveParamWithEmployeeParam)

    suspend fun deleteGive(param : GiveParamWithEmployeeParam)
}
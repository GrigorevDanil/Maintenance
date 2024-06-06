package com.example.domain.repositories

import com.example.domain.entities.GiveParamWithEmployeeParam
import kotlinx.coroutines.flow.Flow

interface IGiveRepository {

    suspend fun getGives() : Flow<List<GiveParamWithEmployeeParam>>

    suspend fun addGive(param : GiveParamWithEmployeeParam)

    suspend fun updateGive(param : GiveParamWithEmployeeParam)

    suspend fun deleteGive(param : GiveParamWithEmployeeParam)
}
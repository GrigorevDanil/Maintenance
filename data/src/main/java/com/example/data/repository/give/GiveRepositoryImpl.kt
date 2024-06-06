package com.example.data.repository.give


import com.example.domain.entities.GiveParamWithEmployeeParam
import com.example.domain.repositories.IGiveRepository
import kotlinx.coroutines.flow.Flow

class GiveRepositoryImpl (
    private val localDataSource : IGiveLocalDataSource
) : IGiveRepository {

    override suspend fun getGives(): Flow<List<GiveParamWithEmployeeParam>> = localDataSource.getGives()

    override suspend fun addGive(param: GiveParamWithEmployeeParam) = localDataSource.addGive(param)

    override suspend fun updateGive(param: GiveParamWithEmployeeParam) = localDataSource.updateGive(param)

    override suspend fun deleteGive(param: GiveParamWithEmployeeParam) = localDataSource.deleteGive(param)

}
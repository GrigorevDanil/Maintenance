package com.example.data.repository.givedetail


import com.example.domain.entities.GiveDetailParam
import com.example.domain.entities.GiveDetailParamWithProductParam
import com.example.domain.repositories.IGiveDetailRepository
import kotlinx.coroutines.flow.Flow

    class GiveDetailRepositoryImpl (
        private val localDataSource : IGiveDetailLocalDataSource
    ) : IGiveDetailRepository {

        override suspend fun getGiveDetails(idGive: Int): Flow<List<GiveDetailParamWithProductParam>> = localDataSource.getGiveDetails(idGive)

        override suspend fun addGiveDetail(param: GiveDetailParamWithProductParam) = localDataSource.addGiveDetail(param)

        override suspend fun updateGiveDetail(param: GiveDetailParamWithProductParam) = localDataSource.updateGiveDetail(param)

        override suspend fun deleteGiveDetail(param: GiveDetailParamWithProductParam) = localDataSource.deleteGiveDetail(param)

    }
package com.example.data.repository.givedetail

import com.example.domain.entities.GiveDetailParam
import com.example.domain.entities.GiveDetailParamWithProductParam
import kotlinx.coroutines.flow.Flow

interface IGiveDetailLocalDataSource {
    suspend fun getGiveDetails(idGive: Int) : Flow<List<GiveDetailParamWithProductParam>>

    suspend fun addGiveDetail(param : GiveDetailParamWithProductParam)

    suspend fun updateGiveDetail(param : GiveDetailParamWithProductParam)

    suspend fun deleteGiveDetail(param : GiveDetailParamWithProductParam)

}
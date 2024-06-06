package com.example.data.repository.givedetail

import com.example.data.db.dao.GiveDetailDao
import com.example.data.mappers.GiveDetailEntityMapper
import com.example.data.mappers.GiveDetailEntityWithProductEntityMapper
import com.example.domain.entities.GiveDetailParamWithProductParam
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class GiveDetailLocalDataSource(
    private val giveDetailDao : GiveDetailDao,
    private val dispatcher: CoroutineDispatcher,
    private val giveDetailMapper: GiveDetailEntityMapper,
    private val giveDetailWithProductMapper: GiveDetailEntityWithProductEntityMapper
) : IGiveDetailLocalDataSource {

    override suspend fun getGiveDetails(idGive : Int): Flow<List<GiveDetailParamWithProductParam>> {
        val giveDetails = giveDetailDao.getGiveDetails(idGive)

        return giveDetails.map { list ->
            list.map { element ->
                giveDetailWithProductMapper.mapToGiveDetailParamWithProductParam(element)
            }
        }
    }

    override suspend fun addGiveDetail(param: GiveDetailParamWithProductParam) = withContext(dispatcher){
        val giveDetailEntity =  giveDetailMapper.mapToGiveDetailEntity(param.giveDetail).apply { IdProduct = param.product.Id }
        giveDetailDao.createGiveDetail(giveDetailEntity)
    }

    override suspend fun updateGiveDetail(param: GiveDetailParamWithProductParam) {
        val giveDetailEntity =  giveDetailMapper.mapToGiveDetailEntity(param.giveDetail).apply { IdProduct = param.product.Id }
        giveDetailDao.updateGiveDetail(giveDetailEntity)
    }

    override suspend fun deleteGiveDetail(param: GiveDetailParamWithProductParam) = withContext(dispatcher){
        val giveDetailEntity =  giveDetailMapper.mapToGiveDetailEntity(param.giveDetail).apply { IdProduct = param.product.Id }
        giveDetailDao.deleteGiveDetail(giveDetailEntity)
    }

}
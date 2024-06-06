package com.example.data.repository.give

import com.example.data.db.dao.GiveDao
import com.example.data.entities.GiveEntityWithEmployeeEntity
import com.example.data.mappers.GiveEntityMapper
import com.example.data.mappers.GiveEntityWithEmployeeEntityMapper
import com.example.domain.entities.GiveParamWithEmployeeParam
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class GiveLocalDataSourceEmpl
    (
    private val giveDao : GiveDao,
    private val dispatcher: CoroutineDispatcher,
    private val giveMapper: GiveEntityMapper,
    private val giveWithEmployeeMapper: GiveEntityWithEmployeeEntityMapper,
) : IGiveLocalDataSource {

    override suspend fun getGives(): Flow<List<GiveParamWithEmployeeParam>> {
        val gives = giveDao.getGives()
        return gives.map { list ->
            list.map { element ->
                giveWithEmployeeMapper.mapToGiveParamWithEmployeeParam(element)
            }
        }
    }

    override suspend fun addGive(param: GiveParamWithEmployeeParam) = withContext(dispatcher) {
        val giveEntity = giveMapper.mapToGiveEntity(param.give).apply { IdEmployee = param.employee.Id }
        giveDao.createGive(giveEntity)
    }

    override suspend fun updateGive(param: GiveParamWithEmployeeParam) = withContext(dispatcher) {
        val giveEntity = giveMapper.mapToGiveEntity(param.give).apply { IdEmployee = param.employee.Id }
        giveDao.updateGive(giveEntity)
    }

    override suspend fun deleteGive(param: GiveParamWithEmployeeParam) = withContext(dispatcher) {
        val giveEntity = giveMapper.mapToGiveEntity(param.give).apply { IdEmployee = param.employee.Id }
        giveDao.deleteGive(giveEntity)
    }

}
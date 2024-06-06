package com.example.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.data.entities.GiveDetailEntity
import com.example.data.entities.GiveDetailEntityWithProductEntity
import com.example.data.entities.ProductEntity
import com.example.domain.entities.GiveDetailParam
import kotlinx.coroutines.flow.Flow

@Dao
interface GiveDetailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createGiveDetail(giveDetail: GiveDetailEntity)

    @Update
    suspend fun updateGiveDetail(giveDetail: GiveDetailEntity)

    @Query("SELECT * FROM GiveDetail LEFT JOIN Product ON Product.IdProduct = GiveDetail.IdGiveDetail WHERE IdGive =:idGive")
    fun getGiveDetails(idGive: Int): Flow<List<GiveDetailEntityWithProductEntity>>

    @Delete
    suspend fun deleteGiveDetail(giveDetail: GiveDetailEntity)
}
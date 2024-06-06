package com.example.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.data.entities.EmployeeEntity
import com.example.data.entities.GiveDetailEntity
import com.example.data.entities.GiveEntity
import com.example.data.entities.GiveEntityWithEmployeeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GiveDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createGive(give: GiveEntity)

    @Update
    suspend fun updateGive(give: GiveEntity)

    @Query("SELECT * FROM Give LEFT JOIN Employee ON Employee.IdEmployee = Give.IdEmployee")
    fun getGives(): Flow<List<GiveEntityWithEmployeeEntity>>

    @Delete
    suspend fun deleteGive(give: GiveEntity)


}
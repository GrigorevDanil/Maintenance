package com.example.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.db.dao.EmployeeDao
import com.example.data.db.dao.GiveDao
import com.example.data.db.dao.GiveDetailDao
import com.example.data.db.dao.ProductDao
import com.example.data.entities.EmployeeEntity
import com.example.data.entities.GiveDetailEntity
import com.example.data.entities.GiveEntity
import com.example.data.entities.ProductEntity

@Database (entities = [EmployeeEntity::class, GiveDetailEntity::class, GiveEntity::class,ProductEntity::class], version = 2)
abstract class MaintenanceDatabase : RoomDatabase() {

    abstract fun getEmployeeDao(): EmployeeDao
    abstract fun getGiveDao(): GiveDao
    abstract fun getGiveDetailDao(): GiveDetailDao
    abstract fun getProductDao(): ProductDao

    companion object {
        private var INSTANCE: MaintenanceDatabase? = null
        fun getInstance(context: Context): MaintenanceDatabase {


            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MaintenanceDatabase::class.java,
                        "DbMaintenance"

                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
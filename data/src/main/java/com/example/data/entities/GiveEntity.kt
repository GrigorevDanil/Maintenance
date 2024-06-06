package com.example.data.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.Date

@Entity (tableName = "Give",
    foreignKeys = [
        ForeignKey(
            entity = EmployeeEntity::class,
            parentColumns = arrayOf("IdEmployee"),
            childColumns = arrayOf("IdEmployee"),
            onDelete = ForeignKey.CASCADE
        )
    ])
data class GiveEntity
    (
    @PrimaryKey (autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "IdGive")
    var Id : Int = 0,
    @ColumnInfo (name = "IdEmployee")
    var IdEmployee : Int,
    @ColumnInfo (name = "DateGive")
    var DateGive : String )
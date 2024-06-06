package com.example.data.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "Employee")
data class EmployeeEntity
    (
    @PrimaryKey (autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "IdEmployee")
    var Id : Int = 0,
    @ColumnInfo(name = "Post")
    var Post : String,
    @ColumnInfo(name = "Surname")
    var Surname : String,
    @ColumnInfo (name = "Name")
    var Name : String,
    @ColumnInfo (name = "Lastname")
    var Lastname : String? = null,
    @ColumnInfo (name = "NumPhone")
    var NumPhone : String,
    @ColumnInfo (name = "Address")
    var Address : String
    ) {

}
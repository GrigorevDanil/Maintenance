package com.example.data.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "Product")
data class ProductEntity
    (
    @PrimaryKey (autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "IdProduct")
    var Id : Int = 0,
    @ColumnInfo (name = "Title")
    var Title : String,
    @ColumnInfo (name = "Model")
    var Model : String,
    @ColumnInfo (name = "CountProduct")
    var CountProduct : Int,
    @ColumnInfo (name = "Unit")
    var Unit : String,
    @ColumnInfo (name = "Price")
    var Price : Int)
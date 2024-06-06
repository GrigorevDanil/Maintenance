package com.example.data.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity (tableName = "GiveDetail",foreignKeys = [
 ForeignKey(
  entity = GiveEntity::class,
  parentColumns = arrayOf("IdGive"),
  childColumns = arrayOf("IdGive"),
  onDelete = ForeignKey.CASCADE
 ),
 ForeignKey(
  entity = ProductEntity::class,
  parentColumns = arrayOf("IdProduct"),
  childColumns = arrayOf("IdProduct"),
  onDelete = ForeignKey.CASCADE
 ),
])
data class GiveDetailEntity
    (
     @PrimaryKey (autoGenerate = true)
     @NonNull
     @ColumnInfo(name = "IdGiveDetail")
     var Id : Int = 0,
     @ColumnInfo (name = "IdGive")
     var IdGive : Int,
     @ColumnInfo (name = "IdProduct")
     var IdProduct : Int,
     @ColumnInfo (name = "CountProduct")
     var CountProduct : Int)
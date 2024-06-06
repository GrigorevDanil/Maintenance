package com.example.maintenance.presentation.entity

import android.os.Parcel
import android.os.Parcelable
import java.util.Date

data class Give(
    var Id: Int,
    var IdEmployee: Int,
    var DateGive: Date
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        Date(parcel.readLong())
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(Id)
        parcel.writeInt(IdEmployee)
        parcel.writeLong(DateGive.time)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Give> {
        override fun createFromParcel(parcel: Parcel): Give {
            return Give(parcel)
        }

        override fun newArray(size: Int): Array<Give?> {
            return arrayOfNulls(size)
        }
    }
}
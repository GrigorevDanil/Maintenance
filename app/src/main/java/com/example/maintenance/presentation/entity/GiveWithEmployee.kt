package com.example.maintenance.presentation.entity

import android.os.Parcel
import android.os.Parcelable

data class GiveWithEmployee(
    var give : Give,
    var employee: Employee
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Give::class.java.classLoader)!!,
        parcel.readParcelable(Employee::class.java.classLoader)!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(give, flags)
        parcel.writeParcelable(employee, flags)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<GiveWithEmployee> {
        override fun createFromParcel(parcel: Parcel): GiveWithEmployee {
            return GiveWithEmployee(parcel)
        }

        override fun newArray(size: Int): Array<GiveWithEmployee?> {
            return arrayOfNulls(size)
        }
    }
}
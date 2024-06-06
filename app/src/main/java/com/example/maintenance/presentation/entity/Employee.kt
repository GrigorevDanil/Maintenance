package com.example.maintenance.presentation.entity

import android.os.Parcel
import android.os.Parcelable

data class Employee(
    var Id: Int,
    var Post: String,
    var Surname: String,
    var Name: String,
    var Lastname: String?,
    var NumPhone: String,
    var Address: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString(),
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(Id)
        parcel.writeString(Post)
        parcel.writeString(Surname)
        parcel.writeString(Name)
        parcel.writeString(Lastname)
        parcel.writeString(NumPhone)
        parcel.writeString(Address)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Employee> {
        override fun createFromParcel(parcel: Parcel): Employee {
            return Employee(parcel)
        }

        override fun newArray(size: Int): Array<Employee?> {
            return arrayOfNulls(size)
        }
    }
}
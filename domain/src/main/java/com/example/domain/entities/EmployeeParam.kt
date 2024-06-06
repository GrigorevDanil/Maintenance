package com.example.domain.entities

import androidx.annotation.NonNull

data class EmployeeParam
    (
    var Id : Int,
    var Post : String,
    var Surname : String,
    var Name : String,
    var Lastname : String?,
    var NumPhone : String,
    var Address : String)
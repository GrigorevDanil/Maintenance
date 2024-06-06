package com.example.maintenance.presentation.entity

import com.example.domain.entities.GiveDetailParam
import com.example.domain.entities.ProductParam

data class GiveDetailWithProduct(
    var giveDetail : GiveDetail,
    var product : Product
)
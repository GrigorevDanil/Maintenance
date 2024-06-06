package com.example.domain.usecase.givedetail

import com.example.domain.entities.GiveDetailParam
import com.example.domain.entities.GiveDetailParamWithProductParam
import com.example.domain.repositories.IGiveDetailRepository

class CreateGiveDetailUseCase(private val giveDetailRepository : IGiveDetailRepository) {
    suspend operator fun invoke(giveDetail : GiveDetailParamWithProductParam) = giveDetailRepository.addGiveDetail(giveDetail)
}
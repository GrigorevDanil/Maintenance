package com.example.domain.usecase.givedetail

import com.example.domain.entities.GiveDetailParam
import com.example.domain.repositories.IGiveDetailRepository

class GetGiveDetailsUseCase(private val giveDetailRepository : IGiveDetailRepository) {
    suspend operator fun invoke() = giveDetailRepository.getGiveDetails()
}
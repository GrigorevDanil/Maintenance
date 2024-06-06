package com.example.domain.usecase.give

import com.example.domain.entities.GiveParamWithEmployeeParam
import com.example.domain.repositories.IGiveRepository

class UpdateGiveUseCase(private val giveRepository : IGiveRepository) {
    suspend operator fun invoke(give: GiveParamWithEmployeeParam) = giveRepository.updateGive(give)
}
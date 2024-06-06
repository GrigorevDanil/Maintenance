package com.example.domain.usecase.give

import com.example.domain.repositories.IGiveRepository

class GetGivesUseCase(private val giveRepository : IGiveRepository) {
    suspend operator fun invoke() = giveRepository.getGives()
}
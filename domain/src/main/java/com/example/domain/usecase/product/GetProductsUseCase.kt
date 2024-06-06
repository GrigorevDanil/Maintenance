package com.example.domain.usecase.product

import com.example.domain.entities.ProductParam
import com.example.domain.repositories.IProductRepository

class GetProductsUseCase(private val productRepository: IProductRepository) {
    suspend operator fun invoke() = productRepository.getProducts()
}
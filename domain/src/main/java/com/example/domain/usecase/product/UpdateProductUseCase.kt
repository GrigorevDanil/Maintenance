package com.example.domain.usecase.product

import com.example.domain.entities.ProductParam
import com.example.domain.repositories.IProductRepository

class UpdateProductUseCase(private val productRepository: IProductRepository) {
    suspend operator fun invoke(product : ProductParam) = productRepository.updateProduct(product)
}
package com.example.domain.usecase.product

import com.example.domain.entities.GiveDetailParam
import com.example.domain.entities.ProductParam
import com.example.domain.repositories.IGiveDetailRepository
import com.example.domain.repositories.IProductRepository

class CreateProductUseCase(private val productRepository: IProductRepository) {
    suspend operator fun invoke(product : ProductParam) = productRepository.addProduct(product)
}
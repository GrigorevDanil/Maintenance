package com.example.domain.repositories

import com.example.domain.entities.ProductParam
import kotlinx.coroutines.flow.Flow

interface IProductRepository {

    suspend fun getProducts() : Flow<List<ProductParam>>

    suspend fun addProduct(param : ProductParam)

    suspend fun updateProduct(param : ProductParam)

    suspend fun deleteProduct(param : ProductParam)
}
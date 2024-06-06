package com.example.data.repository.product

import com.example.domain.entities.ProductParam
import kotlinx.coroutines.flow.Flow

interface IProductLocalDataSource {

    suspend fun getProducts() : Flow<List<ProductParam>>

    suspend fun addProduct(param : ProductParam)

    suspend fun updateProduct(param : ProductParam)

    suspend fun deleteProduct(param : ProductParam)

}
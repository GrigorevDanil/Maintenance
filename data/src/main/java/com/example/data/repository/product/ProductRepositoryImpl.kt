package com.example.data.repository.product


import com.example.domain.entities.ProductParam
import com.example.domain.repositories.IProductRepository
import kotlinx.coroutines.flow.Flow

class ProductRepositoryImpl (
    private val localDataSource : IProductLocalDataSource
) : IProductRepository {

    override suspend fun getProducts(): Flow<List<ProductParam>> = localDataSource.getProducts()

    override suspend fun addProduct(param: ProductParam) = localDataSource.addProduct(param)


    override suspend fun updateProduct(param: ProductParam) = localDataSource.updateProduct(param)


    override suspend fun deleteProduct(param: ProductParam) = localDataSource.deleteProduct(param)

}
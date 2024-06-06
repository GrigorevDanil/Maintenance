package com.example.data.repository.product

import android.util.Log
import com.example.data.db.dao.ProductDao
import com.example.data.mappers.ProductEntityMapper
import com.example.domain.entities.ProductParam
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class ProductLocalDataSourceImpl(
    private val productDao : ProductDao,
    private val dispatcher: CoroutineDispatcher,
    private val productMapper: ProductEntityMapper
) : IProductLocalDataSource {

    override suspend fun getProducts(): Flow<List<ProductParam>> {
        val products = productDao.getProducts()
        return products.map { list ->
            list.map { element ->
                productMapper.mapToProductParam(element)

            }
        }
    }

    override suspend fun addProduct(param: ProductParam) = withContext(dispatcher){
        productDao.createProduct(productMapper.mapToProductEntity(param))
    }

    override suspend fun updateProduct(param: ProductParam) {
        productDao.updateProduct(productMapper.mapToProductEntity(param))
    }

    override suspend fun deleteProduct(param: ProductParam) = withContext(dispatcher){
        productDao.deleteProducts(productMapper.mapToProductEntity(param))
    }


}
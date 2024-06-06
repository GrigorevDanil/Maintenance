package com.example.maintenance.presentation.ui.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.product.CreateProductUseCase
import com.example.domain.usecase.product.DeleteProductUseCase
import com.example.domain.usecase.product.GetProductsUseCase
import com.example.domain.usecase.product.UpdateProductUseCase
import com.example.maintenance.presentation.entity.Product
import com.example.maintenance.presentation.mappers.ProductMapper
import kotlinx.coroutines.launch

class ProductViewModel(
    private val createProductUseCase: CreateProductUseCase,
    private val updateProductUseCase: UpdateProductUseCase,
    private val deleteProductUseCase: DeleteProductUseCase,
    private val getProductsUseCase: GetProductsUseCase,
    private val productMapper : ProductMapper) : ViewModel() {

    private val _products = MutableLiveData<List<Product>>()
    val products = _products

    fun getProducts() = viewModelScope.launch {
        getProductsUseCase.invoke()
            .collect { productList ->
                _products.postValue(productMapper.mapProductParamListToProductList(productList))
            }
    }

    fun addProduct(product: Product)= viewModelScope.launch {
         createProductUseCase.invoke(productMapper.mapProductToProductParam(product))
    }

    fun updateProduct(product: Product)= viewModelScope.launch {
        updateProductUseCase.invoke(productMapper.mapProductToProductParam(product))
    }

    fun deleteProduct(product: Product)= viewModelScope.launch {
        deleteProductUseCase.invoke(productMapper.mapProductToProductParam(product))
    }

}
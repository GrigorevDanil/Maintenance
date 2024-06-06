package com.example.maintenance.presentation.mappers

import com.example.domain.entities.ProductParam
import com.example.maintenance.presentation.entity.Product

class ProductMapper {

    fun mapProductParamListToProductList(listProductParam : List<ProductParam>) :List<Product>
    {
        val products = arrayListOf<Product>()
        for (productParam in listProductParam) {

            products.add(
                Product(
                    Id = productParam.Id,
                    Title = productParam.Title,
                    Model = productParam.Model,
                    CountProduct = productParam.CountProduct,
                    Unit = productParam.Unit,
                    Price = productParam.Price)
            )
        }
        return products.sortedBy { it.Id }
    }

    fun mapProductParamToProduct(productParam : ProductParam) : Product
    {
        return Product(
            Id = productParam.Id,
            Title = productParam.Title,
            Model = productParam.Model,
            CountProduct = productParam.CountProduct,
            Unit = productParam.Unit,
            Price = productParam.Price)
    }

    fun mapProductToProductParam(product : Product) : ProductParam
    {
        return ProductParam(
            Id = product.Id,
            Title = product.Title,
            Model = product.Model,
            CountProduct = product.CountProduct,
            Unit = product.Unit,
            Price = product.Price)
    }

}
package com.example.data.mappers

import com.example.data.entities.ProductEntity
import com.example.domain.entities.ProductParam

class ProductEntityMapper {

    fun mapToProductEntity(productParam : ProductParam) : ProductEntity
    {
        return ProductEntity(
            Id = productParam.Id,
            Title = productParam.Title,
            Model = productParam.Model,
            CountProduct = productParam.CountProduct,
            Unit = productParam.Unit,
            Price = productParam.Price )
    }

    fun mapToProductParam(productEntity : ProductEntity) : ProductParam
    {
        return ProductParam(
            Id = productEntity.Id,
            Title = productEntity.Title,
            Model = productEntity.Model,
            CountProduct = productEntity.CountProduct,
            Unit = productEntity.Unit,
            Price = productEntity.Price )
    }
}
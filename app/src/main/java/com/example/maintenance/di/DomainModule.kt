package com.example.maintenance.di

import com.example.domain.usecase.employee.CreateEmployeeUseCase
import com.example.domain.usecase.employee.DeleteEmployeeUseCase
import com.example.domain.usecase.employee.GetEmployeesUseCase
import com.example.domain.usecase.employee.UpdateEmployeeUseCase
import com.example.domain.usecase.give.CreateGiveUseCase
import com.example.domain.usecase.give.DeleteGiveUseCase
import com.example.domain.usecase.give.GetGivesUseCase
import com.example.domain.usecase.give.UpdateGiveUseCase
import com.example.domain.usecase.givedetail.CreateGiveDetailUseCase
import com.example.domain.usecase.givedetail.DeleteGiveDetailsUseCase
import com.example.domain.usecase.givedetail.GetGiveDetailsUseCase
import com.example.domain.usecase.givedetail.UpdateGiveDetailsUseCase
import com.example.domain.usecase.product.CreateProductUseCase
import com.example.domain.usecase.product.DeleteProductUseCase
import com.example.domain.usecase.product.GetProductsUseCase
import com.example.domain.usecase.product.UpdateProductUseCase
import org.koin.dsl.module

val domainModule = module{

    //employee

    factory<CreateEmployeeUseCase>{
        CreateEmployeeUseCase(get())
    }

    factory<UpdateEmployeeUseCase>{
        UpdateEmployeeUseCase(get())
    }

    factory<DeleteEmployeeUseCase>{
        DeleteEmployeeUseCase(get())
    }

    factory<GetEmployeesUseCase>{
        GetEmployeesUseCase(get())
    }

    //give

    factory<CreateGiveUseCase>{
        CreateGiveUseCase(get())
    }

    factory<UpdateGiveUseCase>{
        UpdateGiveUseCase(get())
    }

    factory<DeleteGiveUseCase>{
        DeleteGiveUseCase(get())
    }

    factory<GetGivesUseCase>{
        GetGivesUseCase(get())
    }

    //giveDetail

    factory<CreateGiveDetailUseCase>{
        CreateGiveDetailUseCase(get())
    }

    factory<UpdateGiveDetailsUseCase>{
        UpdateGiveDetailsUseCase(get())
    }

    factory<DeleteGiveDetailsUseCase>{
        DeleteGiveDetailsUseCase(get())
    }

    factory<GetGiveDetailsUseCase>{
        GetGiveDetailsUseCase(get())
    }

    //product

    factory<CreateProductUseCase>{
        CreateProductUseCase(get())
    }

    factory<UpdateProductUseCase>{
        UpdateProductUseCase(get())
    }

    factory<DeleteProductUseCase>{
        DeleteProductUseCase(get())
    }

    factory<GetProductsUseCase>{
        GetProductsUseCase(get())
    }
}
package com.example.maintenance.di

import com.example.data.db.MaintenanceDatabase
import com.example.data.mappers.EmployeeEntityMapper
import com.example.data.mappers.GiveDetailEntityWithProductEntityMapper
import com.example.data.mappers.GiveEntityMapper
import com.example.data.mappers.GiveEntityWithEmployeeEntityMapper
import com.example.data.mappers.ProductEntityMapper
import com.example.data.repository.employee.EmployeeLocalDataSourceImpl
import com.example.data.repository.employee.EmployeeRepositoryImpl
import com.example.data.repository.employee.IEmployeeLocalDataSource
import com.example.data.repository.give.GiveLocalDataSourceEmpl
import com.example.data.repository.give.GiveRepositoryImpl
import com.example.data.repository.give.IGiveLocalDataSource
import com.example.data.repository.givedetail.GiveDetailLocalDataSource
import com.example.data.repository.givedetail.GiveDetailRepositoryImpl
import com.example.data.repository.givedetail.IGiveDetailLocalDataSource
import com.example.data.repository.product.IProductLocalDataSource
import com.example.data.repository.product.ProductLocalDataSourceImpl
import com.example.data.repository.product.ProductRepositoryImpl
import com.example.domain.repositories.IEmployeeRepository
import com.example.domain.repositories.IGiveDetailRepository
import com.example.domain.repositories.IGiveRepository
import com.example.domain.repositories.IProductRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    single<MaintenanceDatabase> {
        MaintenanceDatabase.getInstance(androidContext())
    }

    single {
        get<MaintenanceDatabase>().getProductDao()
    }

    single {
        get<MaintenanceDatabase>().getEmployeeDao()
    }

    single {
        get<MaintenanceDatabase>().getGiveDao()
    }

    single {
        get<MaintenanceDatabase>().getGiveDetailDao()
    }
}

val dataModule = module {


    //employee

    single {
        EmployeeEntityMapper()
    }

    single<IEmployeeRepository> {
        EmployeeRepositoryImpl(get())
    }

    single<IEmployeeLocalDataSource> {
        EmployeeLocalDataSourceImpl(get(),get(),get())
    }

    //give

    single {
        GiveEntityWithEmployeeEntityMapper(get(),get())
    }

    single {
        GiveEntityMapper()
    }

    single<IGiveRepository> {
        GiveRepositoryImpl(get())
    }

    single<IGiveLocalDataSource> {
        GiveLocalDataSourceEmpl(get(),get(),get(),get())
    }

    //giveDetail


    single {
        GiveDetailEntityWithProductEntityMapper(get(),get())
    }

    single<IGiveDetailRepository> {
        GiveDetailRepositoryImpl(get())
    }

    single<IGiveDetailLocalDataSource> {
        GiveDetailLocalDataSource(get(),get(),get(),get())
    }

    //product

    single {
        ProductEntityMapper()
    }

    single<IProductRepository> {
        ProductRepositoryImpl(get())
    }

    single<IProductLocalDataSource> {
        ProductLocalDataSourceImpl(get(),get(),get())
    }
}
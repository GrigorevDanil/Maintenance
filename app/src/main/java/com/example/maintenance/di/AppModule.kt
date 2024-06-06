package com.example.maintenance.di

import com.example.maintenance.presentation.entity.Product
import com.example.maintenance.presentation.mappers.EmployeeMapper
import com.example.maintenance.presentation.mappers.GiveDetailMapper
import com.example.maintenance.presentation.mappers.GiveDetailWithProductMapper
import com.example.maintenance.presentation.mappers.GiveMapper
import com.example.maintenance.presentation.mappers.GiveWithEmployeeMapper
import com.example.maintenance.presentation.mappers.ProductMapper
import com.example.maintenance.presentation.ui.ConfirmDialog
import com.example.maintenance.presentation.ui.IDialogListener
import com.example.maintenance.presentation.ui.employee.EmployeeDialog
import com.example.maintenance.presentation.ui.employee.EmployeeViewModel
import com.example.maintenance.presentation.ui.give.GiveViewModel
import com.example.maintenance.presentation.ui.give.dialog.GiveDetailDialog
import com.example.maintenance.presentation.ui.give.dialog.GiveDialog
import com.example.maintenance.presentation.ui.give.dialog.GiveDialogViewModel
import com.example.maintenance.presentation.ui.product.ProductDialog
import com.example.maintenance.presentation.ui.product.ProductViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        ProductViewModel(get(), get(), get(), get(),get())
    }

    viewModel {
        EmployeeViewModel(get(), get(), get(), get(),get())
    }

    viewModel {
        GiveViewModel(get(), get(), get(), get(),get())
    }

    viewModel {
        GiveDialogViewModel(get(), get(), get(), get(),get(),get(),get(),get(),get())
    }

    single<CoroutineDispatcher> {
        Dispatchers.IO
    }

    factory{
        ConfirmDialog(get(),get())
    }

    //giveDetail

    single {
        GiveDetailMapper()
    }

    single {
        GiveDetailWithProductMapper(get(),get())
    }

    single {
        GiveDetailDialog(get(),get(),get(),get())
    }

    //give

    single {
        GiveMapper()
    }

    single {
        GiveWithEmployeeMapper(get(),get())
    }

    single {
        GiveDialog(get())
    }


    //employee

    single {
        EmployeeMapper()
    }


    factory{
        EmployeeDialog(get(),get())
    }

    //prouduct

    single {
        ProductMapper()
    }


    factory{
        ProductDialog(get(),get())
    }
}
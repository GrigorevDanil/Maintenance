package com.example.maintenance.app

import android.app.Application
import com.example.maintenance.di.appModule
import com.example.maintenance.di.dataModule
import com.example.maintenance.di.databaseModule
import com.example.maintenance.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(appModule, dataModule, databaseModule ,domainModule))
        }

    }

}
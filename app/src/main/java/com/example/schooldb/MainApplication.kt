package com.example.schooldb

import android.app.Application
import com.example.schooldb.data.di.dataModule
import com.example.schooldb.domain.di.domainModule
import com.example.schooldb.presentation.di.presentationModule
import com.example.schooldb.presentation.navigation.di.navigationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

const val TAG = "MyApp"

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()

            androidContext(this@MainApplication)

            modules(dataModule, domainModule, navigationModule, presentationModule)
        }
    }
}
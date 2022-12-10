package com.example.schooldb

import android.app.Application
import com.example.schooldb.di.instrumentedTestModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class TestApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()

            androidContext(this@TestApplication)

            modules(instrumentedTestModule)
        }
    }
}
package com.example.schooldb.data.di

import com.example.schooldb.data.localDB.SchoolDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single {
        SchoolDatabase.getInstance(androidContext())
    }
}
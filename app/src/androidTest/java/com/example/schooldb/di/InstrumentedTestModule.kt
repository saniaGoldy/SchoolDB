package com.example.schooldb.di

import androidx.room.Room
import com.example.schooldb.data.localDB.SchoolDatabase
import org.koin.dsl.module

val instrumentedTestModule = module {
    single {
        Room.inMemoryDatabaseBuilder(get(), SchoolDatabase::class.java)
            .allowMainThreadQueries()
            .build()
    }

    single { get<SchoolDatabase>().schoolDao }
}
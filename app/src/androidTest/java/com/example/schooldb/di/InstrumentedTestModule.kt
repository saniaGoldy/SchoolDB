package com.example.schooldb.di

import androidx.room.Room
import com.example.schooldb.data.localDB.SchoolDao
import com.example.schooldb.data.localDB.SchoolDatabase
import org.koin.dsl.module

val instrumentedTestModule = module {
    single<SchoolDatabase> {
        Room.inMemoryDatabaseBuilder(get(), SchoolDatabase::class.java)
            .allowMainThreadQueries()
            .build()
    }

    single<SchoolDao> { get<SchoolDatabase>().schoolDao }
}
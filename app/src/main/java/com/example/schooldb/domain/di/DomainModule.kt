package com.example.schooldb.domain.di

import com.example.schooldb.domain.repository.SchoolRepository
import com.example.schooldb.domain.repository.SchoolRepositoryImplementation
import org.koin.dsl.module

val domainModule = module {
    single <SchoolRepository>{
        SchoolRepositoryImplementation(get())
    }
}
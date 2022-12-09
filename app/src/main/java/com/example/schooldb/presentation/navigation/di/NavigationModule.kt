package com.example.schooldb.presentation.navigation.di

import com.example.schooldb.presentation.navigation.NavigatorImpl
import com.example.schooldb.presentation.navigation.Navigator
import org.koin.dsl.module

val navigationModule = module{
    single<Navigator> { NavigatorImpl() }
}
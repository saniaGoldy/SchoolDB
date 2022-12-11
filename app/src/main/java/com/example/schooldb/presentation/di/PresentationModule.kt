package com.example.schooldb.presentation.di

import com.example.schooldb.presentation.home.HomeViewModel
import com.example.schooldb.presentation.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        LoginViewModel(get())
    }
    viewModel {
        HomeViewModel(get(), get())
    }
}
package com.example.schooldb.presentation.home

import androidx.lifecycle.ViewModel
import com.example.schooldb.domain.repository.SchoolRepository
import com.example.schooldb.presentation.navigation.Navigator

class HomeViewModel(
private val navigator: Navigator,
private val repository: SchoolRepository
) : ViewModel(), Navigator by navigator
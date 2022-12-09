package com.example.schooldb.presentation.login

import androidx.lifecycle.ViewModel
import com.example.schooldb.presentation.navigation.Navigator

class LoginViewModel(
private val navigator: Navigator
) : ViewModel(), Navigator by navigator
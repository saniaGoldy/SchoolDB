package com.example.schooldb.presentation.login

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.schooldb.presentation.navigation.Navigator
import com.example.schooldb.presentation.navigation.destinations.login.HomeDestination
import com.example.schooldb.presentation.utils.validatePassword
import com.example.schooldb.presentation.utils.validatePhoneOrEmail
import com.example.schooldb.ui.components.InputTextField
import com.example.schooldb.ui.theme.SchoolDBTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = koinViewModel()
){
    LoginScreenContent(viewModel)
}

@Composable
private fun LoginScreenContent(
    navigator: Navigator
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            var login: String by rememberSaveable(inputs = emptyArray()) {
                mutableStateOf("")
            }
            var isLoginValid: Boolean by rememberSaveable(inputs = emptyArray()) {
                mutableStateOf(false)
            }

            var password: String by rememberSaveable(inputs = emptyArray()) {
                mutableStateOf("")
            }
            var isPasswordValid: Boolean by rememberSaveable(inputs = emptyArray()) {
                mutableStateOf(false)
            }

            var isInputValid: Boolean by rememberSaveable(
                inputs = arrayOf(
                    isLoginValid,
                    isPasswordValid
                )
            ) {
                mutableStateOf(isLoginValid && isPasswordValid)
            }

            InputTextField(
                value = "",
                placeholder = "Email or Phone number",
                onTextValidation = { input ->
                    login = input
                    validatePhoneOrEmail(input).also {
                        isLoginValid = it
                    }
                })

            InputTextField(value = "", placeholder = "Password", onTextValidation = { input ->
                password = input
                validatePassword(input).also {
                    isPasswordValid = it
                }
            })

            val context = LocalContext.current

            Button(onClick = {
                if (isInputValid) {
                    navigator.navigate(HomeDestination.createHomeRoute(login))
                } else {
                    Toast.makeText(context, "Invalid Input", Toast.LENGTH_SHORT).show()
                }
            })
            {
                Text(text = "Login")
            }

        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    SchoolDBTheme() {
        LoginScreen()
    }
}


package com.example.schooldb.presentation.utils

const val PASSWORD_REGEX =
    "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#\$%^&*()\\\\-_=+{}|?>.<,:;~`’]{8,}\$"

const val EMAIL_REGEX = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,64}"

const val PHONE_REGEX = "^\\+(?:[0-9]?){6,14}[0-9]$"

const val USERNAME_REGEX = "([A-Za-z0-9\\-\\_]+)"

fun validateUsername(input: String) = input.validate(USERNAME_REGEX)

fun validatePassword(input: String) = input.validate(PASSWORD_REGEX)

fun validatePhoneOrEmail(input: String) = if (input.isPhoneNumber())
    input.validate(PHONE_REGEX)
else
    input.validate(EMAIL_REGEX)

private fun String.isPhoneNumber(): Boolean {
    return this.contains("+")
}

fun String.validate(regex: String) =
    this.matches(Regex(regex))
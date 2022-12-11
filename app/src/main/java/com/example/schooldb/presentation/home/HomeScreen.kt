package com.example.schooldb.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun HomeScreen(
    string: String
) {
    Box(contentAlignment = Alignment.Center) {
        Text(text = string)
    }
}
package com.example.schooldb.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputTextField(
    modifier: Modifier = Modifier,
    value: String,
    onTextValidation: ((String) -> Boolean)? = null,
    placeholder: String,
    supportingText: String? = null,
    colors: TextFieldColors = TextFieldDefaults.outlinedTextFieldColors(),
    shape: Shape = AppTextFieldDefaults.shape,
) {
    var isInputValid by rememberSaveable(inputs = emptyArray()) {
        mutableStateOf(true)
    }
    var text by rememberSaveable(inputs = emptyArray()) {
        mutableStateOf(value)
    }

    OutlinedTextField(
        modifier = modifier
            .padding(AppTextFieldDefaults.padding)
            .heightIn(AppTextFieldDefaults.height)
            .fillMaxWidth(),
        value = text,
        onValueChange = { input ->
            text = input
            onTextValidation?.let { validate ->
                isInputValid = validate(text)
            }
        },
        placeholder = { Text(placeholder) },
        colors = colors,
        shape = shape,
        supportingText = { supportingText?.let { Text(supportingText) } },
        singleLine = true,
        isError = !isInputValid
    )
}


object AppTextFieldDefaults {

    val padding = PaddingValues(horizontal = 12.dp, vertical = 10.dp)
    val height = 40.dp
    val shape = RoundedCornerShape(4.dp)
}
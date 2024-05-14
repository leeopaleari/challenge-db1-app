package br.com.fiap.mentora.common.input

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun EmailInputField(
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String = "E-mail",
) {

    var text by rememberSaveable {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = text,
        onValueChange = {
            text = it
            onValueChange(it)
        },
        modifier = modifier
            .fillMaxWidth(),
        label = { Text(text = "E-mail") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Color(0xFF012640),
            unfocusedContainerColor = Color(0xFF0021017),
            focusedContainerColor = Color(0xFF0021017),
            focusedBorderColor = Color(0xFF2BFDBE),
        )
    )
}
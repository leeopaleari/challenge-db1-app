package br.com.fiap.mentora.common.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TitleText(modifier: Modifier = Modifier, text: String) {
    Text(text = text, modifier = modifier, style = MaterialTheme.typography.titleLarge.copy())
}
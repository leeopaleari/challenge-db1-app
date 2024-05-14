package br.com.fiap.mentora.screens.app.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun ProfileScreen(
    onLogout: () -> Unit
) {
    Column {
        Text(text = "Profile Screen")

        Button(onClick = { onLogout() }) {
            Text(text = "Sair")
        }
    }
}
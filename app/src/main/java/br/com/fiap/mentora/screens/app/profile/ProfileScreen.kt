package br.com.fiap.mentora.screens.app.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.mentora.R
import br.com.fiap.mentora.ui.theme.MontserratBold
import br.com.fiap.mentora.ui.theme.TextContrast

@Composable
fun ProfileScreen(
    onLogout: () -> Unit
) {
    Column(
        modifier = Modifier.padding(20.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile_match_img),
                contentDescription = "",
                modifier = Modifier.size(100.dp)
            )
            Text(
                text = "Leonardo",
                fontSize = 20.sp,
                fontFamily = MontserratBold,
                color = Color(0xFF93CDD7)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row {
            DataText("E-mail", "leologe@gmail.com")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row {
            DataText("Telefone", "(11) 99123-3344")
        }
        Spacer(modifier = Modifier.height(20.dp))

        Row {
            DataText(
                "Sobre Leonardo",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut."
            )
        }

        Spacer(modifier = Modifier.height(40.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = { onLogout() }) {
                Text(text = "Sair", color = TextContrast)
            }

        }
    }
}

@Composable
fun DataText(label: String, text: String) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = label, fontSize = 12.sp, color = Color(0xFF2BDEFD))

        Text(text = text, fontSize = 16.sp, color = Color(0xFF93CDD7))
    }
}


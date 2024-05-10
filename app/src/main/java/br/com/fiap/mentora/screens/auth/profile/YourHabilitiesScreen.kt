package br.com.fiap.mentora.screens.auth.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.mentora.ui.theme.BackgroundDark
import br.com.fiap.mentora.ui.theme.MontserratSemiBold
import br.com.fiap.mentora.ui.theme.TextColorPrimary
import br.com.fiap.mentora.ui.theme.TextContrast

@Composable
fun YourHabilitiesScreen(modifier: Modifier = Modifier) {
    var sliderPosition by remember { mutableFloatStateOf(0f) }

    Scaffold(
        containerColor = BackgroundDark
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Column(
                modifier = modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Nível das suas habilidades",
                    style = MaterialTheme.typography.titleLarge.copy(color = TextColorPrimary)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(text = "Frontend", Modifier.fillMaxWidth())

                Spacer(modifier = Modifier.height(8.dp))
//                Color(0xFF2BDEFD)
                LazyColumn {
                    items(5) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp)
                        ) {

                            Card(
                                colors = CardDefaults.cardColors(
                                    containerColor = Color(0xFF2BDEFD)
                                ),
                                shape = RoundedCornerShape(20.dp)
                            ) {
                                Row(
                                    modifier = Modifier
                                        .padding(vertical = 8 .dp, horizontal = 10.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Icon(
                                        modifier = Modifier.size(16.dp),
                                        imageVector = Icons.Filled.Done,
                                        contentDescription = "Localized description",
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(
                                        text = "Html",
                                        color = TextContrast,
                                        fontFamily = MontserratSemiBold,
                                        fontSize = 14.sp
                                    )

                                }

                            }

                            Slider(value = sliderPosition, onValueChange = { sliderPosition = it }, steps = 1)

                        }
                    }
                }
            }
        }
    }
}
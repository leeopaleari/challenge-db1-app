package br.com.fiap.mentora.screens.app.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import br.com.fiap.mentora.R
import br.com.fiap.mentora.common.chip.HabilityCard
import br.com.fiap.mentora.ui.theme.BackgroundDark
import br.com.fiap.mentora.ui.theme.MontserratBold
import br.com.fiap.mentora.ui.theme.PrimaryColor

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MatchCard() {

    Card(
        modifier = Modifier
            .fillMaxWidth(0.9f),
        border = BorderStroke(width = 2.dp, color = Color(0xFFFFFFFF)),
        colors = CardDefaults.cardColors(
            containerColor = BackgroundDark
        )
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .padding(bottom = 50.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile_match_img),
                    contentDescription = ""
                )
                Text(
                    text = "Miguel",
                    fontFamily = MontserratBold,
                    fontSize = 32.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row {
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut.",
                    color = Color(0xFFFFFFFF),
                    fontSize = 14.sp
                )
            }
            Spacer(modifier = Modifier.height(60.dp))

            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(
                    space = 8.dp,
                    alignment = Alignment.CenterHorizontally
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                HabilityCard(text = "Html")

                HabilityCard(text = "JavaScript")

                HabilityCard(text = "NodeJS")

                HabilityCard(text = "Angular")
            }

        }

    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(
            space = 8.dp,
            alignment = Alignment.CenterHorizontally
        ),
        modifier = Modifier
            .fillMaxWidth()
            .offset(y = (-42).dp)
    ) {
        Button(
            modifier = Modifier.size(60.dp),
            onClick = {},
            shape = CircleShape,
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            )
        ) {
            Icon(
                imageVector = Icons.Outlined.Close,
                contentDescription = "Botão Rejeitar",
                modifier = Modifier.size(25.dp),
                tint = Color(0xFF012640)
            )
        }

        Button(
            modifier = Modifier.size(80.dp),
            onClick = {},
            shape = CircleShape,
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(listOf(Color(0xFF011B2E), PrimaryColor))
                    ),
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = "Botão Like",
                    modifier = Modifier.size(40.dp),
                    tint = Color.White
                )
            }
        }

        Button(
            modifier = Modifier.size(60.dp),
            onClick = {},
            shape = CircleShape,
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            )
        ) {
            Icon(
                imageVector = Icons.Outlined.Star,
                contentDescription = "Botão Favoritar",
                tint = Color(0xFF012640)
            )
        }
    }
}

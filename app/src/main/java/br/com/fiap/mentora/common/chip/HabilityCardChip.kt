package br.com.fiap.mentora.common.chip

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.mentora.ui.theme.MontserratSemiBold
import br.com.fiap.mentora.ui.theme.TextContrast

@Composable
fun HabilityCard(text: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier.padding(vertical = 4.dp)) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF2BDEFD)
            ),
            shape = RoundedCornerShape(20.dp)
        ) {
            Row(
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    modifier = Modifier.size(14.dp),
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Localized description",
                    tint = Color.Black
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = text,
                    color = TextContrast,
                    fontFamily = MontserratSemiBold,
                    fontSize = 12.sp
                )
            }
        }
    }
}
package br.com.fiap.mentora.screens.auth.profile.components

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SkillSlider(modifier: Modifier = Modifier) {
    var sliderPosition by remember { mutableFloatStateOf(1f) }

    Column(
        horizontalAlignment = Alignment.End,
        modifier = modifier
    ) {
        Text(
            text = when (sliderPosition.toInt()) {
                1 -> "Básico"
                2 -> "Intermediário"
                3 -> "Avançado"
                else -> ""
            }, fontSize = 12.sp
        )
        Slider(
            modifier = Modifier.height(28.dp),
            value = sliderPosition,
            onValueChange = {
                sliderPosition = it
                Log.i("skillSlider", "SkillSlider: $it")
            },
            valueRange = 1f..3f,
            steps = 1,
        )
    }
}
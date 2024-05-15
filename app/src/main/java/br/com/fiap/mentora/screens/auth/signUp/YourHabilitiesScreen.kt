package br.com.fiap.mentora.screens.auth.signUp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.mentora.common.button.BaseButton
import br.com.fiap.mentora.common.button.ButtonType
import br.com.fiap.mentora.common.chip.HabilityCard
import br.com.fiap.mentora.screens.auth.signUp.components.SkillSlider
import br.com.fiap.mentora.ui.theme.BackgroundDark
import br.com.fiap.mentora.ui.theme.MontserratSemiBold
import br.com.fiap.mentora.ui.theme.PrimaryColor
import br.com.fiap.mentora.ui.theme.TextColorPrimary
import br.com.fiap.mentora.ui.theme.TextContrast


@Composable
fun YourHabilitiesScreen(
    modifier: Modifier = Modifier,
    onPopBackStack: () -> Unit,
    onNavigateToHome: () -> Unit
) {
    val scrollState = rememberScrollState()

    Scaffold(
        containerColor = BackgroundDark
    ) { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom // Coloca os botões no final da tela

        ) {
            Text(
                text = "Nível das suas habilidades",
                style = MaterialTheme.typography.titleLarge.copy(color = TextColorPrimary)
            )

            Spacer(modifier = Modifier.height(20.dp))

            val habilidades = mapOf(
                "Frontend" to listOf("Html", "JavaScript", "Angular", "React"),
                "Backend" to listOf("NodeJs",  "Dotnet")
            )

            SkillsContent(skillsItems = habilidades)

            Spacer(modifier = Modifier.height(40.dp))

            Spacer(modifier = Modifier.weight(1f))

            Column {
                Text(
                    text = "Possui preferência de horário?",
                    fontSize = 15.sp,
                    fontFamily = MontserratSemiBold,
                    modifier = Modifier.fillMaxWidth()
                )

                var selectedOption by remember { mutableStateOf<String?>(null) }

                val options = listOf("Manhã", "Tarde", "Noite")

                RadioButtonGroup(
                    options = options,
                    selectedOption = selectedOption,
                    onOptionSelected = { selectedOption = it }
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BaseButton(
                    text = "Voltar",
                    onClick = onPopBackStack,
                    modifier = Modifier.weight(0.5f),
                    buttonType = ButtonType.OUTLINED
                )
                Spacer(modifier = Modifier.width(16.dp))
                BaseButton(
                    text = "Concluir",
                    onClick = { onNavigateToHome() },
                    modifier = Modifier.weight(0.5f)
                )
            }
        }
    }
}

@Composable
private fun SkillsContent(skillsItems: Map<String, List<String>>) {
    skillsItems.forEach { (category, skills) ->
        Column(modifier = Modifier.padding(bottom = 16.dp)) {
            Text(text = category, Modifier.fillMaxWidth())

            skills.forEach { skill ->
                HabilityRow(skill = skill)
            }
        }
    }
}

@Composable
private fun HabilityRow(skill: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        HabilityCard(text = skill, modifier = Modifier.weight(0.5f))
        SkillSlider(modifier = Modifier.fillMaxWidth(0.5f))
    }
}



@Composable
private fun RadioButtonGroup(
    options: List<String>,
    selectedOption: String?,
    onOptionSelected: (String) -> Unit
) {
    Row {
        options.forEach { option ->
            RadioButton(
                text = option,
                isSelected = option == selectedOption,
                onSelect = { onOptionSelected(option) }
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RadioButton(
    text: String,
    isSelected: Boolean,
    onSelect: () -> Unit
) {

    InputChip(
        onClick = onSelect,
        label = { Text(text) },
        selected = isSelected,
        colors = InputChipDefaults.inputChipColors(
            containerColor = Color(0xFF011B2E),
            labelColor = Color(0xFF2BDEFD),
            selectedContainerColor = PrimaryColor,
            selectedLabelColor = TextContrast,
        ),
        border = InputChipDefaults.inputChipBorder(
            selectedBorderColor = PrimaryColor,
            borderColor = Color(0xFF011B2E)
        ),
    )
}
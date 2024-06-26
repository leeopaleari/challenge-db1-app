package br.com.fiap.mentora.screens.auth.signUp

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.fiap.mentora.common.button.BaseButton
import br.com.fiap.mentora.common.button.ButtonType
import br.com.fiap.mentora.common.chip.CustomInputChip
import br.com.fiap.mentora.common.input.BaseInputField
import br.com.fiap.mentora.screens.auth.signUp.viewmodel.SignUpViewModel
import br.com.fiap.mentora.ui.theme.BackgroundDark
import br.com.fiap.mentora.ui.theme.MontserratBold
import br.com.fiap.mentora.ui.theme.PrimaryColor
import br.com.fiap.mentora.ui.theme.TextColorPrimary

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun AboutYouRegisterScreen(
    modifier: Modifier = Modifier,
    navigateToYourHabilitiesScreen: () -> Unit,
    onPopBackStack: () -> Unit,
    viewModel: SignUpViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsState()
    Log.i("teste", "AboutYouRegisterScreen: ${uiState.fullName}")
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

                Spacer(modifier = Modifier.height(40.dp))

                Row(
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.fillMaxWidth()
                )
                {
                    Text(
                        text = "Olá, ",
                        fontSize = 20.sp,
                        fontFamily = MontserratBold,
                        color = TextColorPrimary
                    )
                    Text(
                        text = "${
                            uiState.fullName.split(" ")[0]
                        }.",
                        fontSize = 20.sp,
                        color = PrimaryColor,
                        fontFamily = MontserratBold
                    )

                }

                Text(
                    text = "Conte-nos sobre você e seus conhecimentos",
                    modifier = Modifier.align(Alignment.Start),
                    fontSize = 14.sp,
                )

                Spacer(modifier = Modifier.height(20.dp))

                BaseInputField(
                    onValueChange = {
                        uiState.onAboutMeChange(it)
                    },
                    label = "Sobre você",
                    placeholder = "Fale um pouco sobre você",
                    textArea = true,
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(text = "Frontend", Modifier.fillMaxWidth())

                Spacer(modifier = Modifier.height(8.dp))
                val frontendSkills = listOf("Html", "Css", "JavaScript", "React", "Vue", "Angular")
                val selectedFrontendSkills = mutableListOf<String>()

                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    frontendSkills.forEach { skill ->
                        CustomInputChip(
                            text = skill,
                            isSelected = selectedFrontendSkills.contains(skill),
                            onClick = {
                                selectedFrontendSkills.add(skill)
                            }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(text = "Backend", Modifier.fillMaxWidth())

                Spacer(modifier = Modifier.height(8.dp))

                val backendSkills =
                    listOf("Node.js", ".NET", "Python", "Go", "Java", "Spring Boot", "Laravel")
                val selectedBackendSkills = mutableListOf<String>()
                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    backendSkills.forEach { skill ->
                        CustomInputChip(
                            text = skill,
                            isSelected = selectedBackendSkills.contains(skill),
                            onClick = {
                                selectedBackendSkills.add(skill)
                            }
                        )
                    }
                }

                Spacer(modifier = Modifier.weight(1f))

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
                        text = "Próximo",
                        enabled = uiState.canNavigateToYourHabilities(),
                        onClick = { navigateToYourHabilitiesScreen() },
                        modifier = Modifier.weight(0.5f)
                    )
                }
            }
        }
    }
}
package br.com.fiap.mentora.ui.screens.auth.profile

import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.mentora.ui.common.button.BaseButton
import br.com.fiap.mentora.ui.common.button.ButtonType
import br.com.fiap.mentora.ui.common.chip.CustomInputChip
import br.com.fiap.mentora.ui.common.input.BaseInputField
import br.com.fiap.mentora.ui.theme.BackgroundDark
import br.com.fiap.mentora.ui.theme.MontserratBold
import br.com.fiap.mentora.ui.theme.PrimaryColor
import br.com.fiap.mentora.ui.theme.TextColorPrimary

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun ProfileRegisterScreen(
    modifier: Modifier = Modifier,
    navigateToYourHabilitiesScreen: () -> Unit,
    onPopBackStack: () -> Unit
) {
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
                        text = "Leonardo.",
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
                    onValueChange = {},
                    label = "Sobre você",
                    placeholder = "Fale um pouco sobre você",
                    textArea = true,
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(text = "Frontend", Modifier.fillMaxWidth())

                Spacer(modifier = Modifier.height(8.dp))

                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    CustomInputChip(text = "Html", onDismiss = {})
                    CustomInputChip(text = "Css", onDismiss = {})
                    CustomInputChip(text = "JavaScript", onDismiss = {})
                    CustomInputChip(text = "React", onDismiss = {})
                    CustomInputChip(text = "Vue", onDismiss = {})
                    CustomInputChip(text = "Angular", onDismiss = {})
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(text = "Backend", Modifier.fillMaxWidth())

                Spacer(modifier = Modifier.height(8.dp))

                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    CustomInputChip(text = "NodeJs", onDismiss = {})
                    CustomInputChip(text = "C# / Dotnet", onDismiss = {})
                    CustomInputChip(text = "Python", onDismiss = {})
                    CustomInputChip(text = "Go", onDismiss = {})
                    CustomInputChip(text = "Java", onDismiss = {})
                    CustomInputChip(text = "TypeScript", onDismiss = {})
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
                        onClick = { navigateToYourHabilitiesScreen() },
                        modifier = Modifier.weight(0.5f)
                    )
                }
            }
        }
    }
}
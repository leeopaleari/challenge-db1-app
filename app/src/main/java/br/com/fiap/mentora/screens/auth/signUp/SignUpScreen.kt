package br.com.fiap.mentora.screens.auth.signUp

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.fiap.mentora.R
import br.com.fiap.mentora.common.button.BaseButton
import br.com.fiap.mentora.common.button.ButtonType
import br.com.fiap.mentora.common.input.BaseInputField
import br.com.fiap.mentora.common.text.TitleText
import br.com.fiap.mentora.screens.auth.signUp.viewmodel.SignUpViewModel
import br.com.fiap.mentora.ui.theme.BackgroundDark

@Composable
fun SignUpScreen(
    onNavigateToProfileScreen: () -> Unit,
    onPopBackStack: () -> Unit,
    viewModel: SignUpViewModel = hiltViewModel()
) {
    val scrollState = rememberScrollState()

    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        containerColor = BackgroundDark
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
                .verticalScroll(scrollState)
        ) {
            Image(
                painter = painterResource(id = R.drawable.signup_robo),
                contentDescription = "Imagem de um robô cartoonizado com um livro na mão",
                modifier = Modifier
                    .size(180.dp, Dp.Unspecified)
                    .aspectRatio(1f)
            )

            Spacer(modifier = Modifier.height(20.dp))

            TitleText(text = "Criar Conta")

            Spacer(modifier = Modifier.height(20.dp))

            BaseInputField(
                onValueChange = {
                    uiState.onNameChange(it)
                },
                label = "Nome completo",
                placeholder = "Digite seu nome completo"
            )

            Spacer(modifier = Modifier.height(20.dp))


            BaseInputField(
                onValueChange = {
                    uiState.onEmailChange(it)
                },
                label = "E-mail",
                placeholder = "exemplo@email.com"
            )

            Spacer(modifier = Modifier.height(20.dp))

            BaseInputField(
                onValueChange = {
                    uiState.onPhoneChange(it)
                },
                label = "Telefone",
                placeholder = "(  ) _____-____"
            )

            Spacer(modifier = Modifier.height(20.dp))

            BaseInputField(
                onValueChange = {
                    uiState.onPasswordChange(it)
                },
                label = "Senha",
                placeholder = "Digite sua senha",
                keyboardType = KeyboardType.Password
            )

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
                    onClick = {
                        onNavigateToProfileScreen()
                    },
                    enabled = uiState.canNavigateToAboutYou(),
                    modifier = Modifier.weight(0.5f)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}
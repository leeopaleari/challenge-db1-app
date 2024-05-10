package br.com.fiap.mentora.screens.auth.signUp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.fiap.mentora.R
import br.com.fiap.mentora.ui.common.button.BaseButton
import br.com.fiap.mentora.ui.common.button.ButtonType
import br.com.fiap.mentora.ui.common.input.BaseInputField
import br.com.fiap.mentora.ui.common.text.TitleText
import br.com.fiap.mentora.ui.theme.BackgroundDark

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    onNavigateToProfileScreen: () -> Unit,
    onPopBackStack: () -> Unit
) {
    val scrollState = rememberScrollState()

    Scaffold(
        containerColor = BackgroundDark
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .verticalScroll(scrollState)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
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
                    onValueChange = {},
                    label = "Nome completo",
                    placeholder = "Digite seu nome completo"
                )

                Spacer(modifier = Modifier.height(20.dp))


                BaseInputField(
                    onValueChange = {},
                    label = "E-mail",
                    placeholder = "exemplo@email.com"
                )

                Spacer(modifier = Modifier.height(20.dp))

                BaseInputField(
                    onValueChange = {},
                    label = "Telefone",
                    placeholder = "(  ) _____-____"
                )

                Spacer(modifier = Modifier.height(20.dp))

                BaseInputField(
                    onValueChange = {},
                    label = "Senha",
                    placeholder = "Digite sua senha"
                )

                Spacer(modifier = Modifier.height(40.dp))

                BaseButton(text = "Cadastrar", onClick = {
                                                         onNavigateToProfileScreen()
                }, modifier = Modifier.fillMaxWidth(0.7f))
                BaseButton(text = "Voltar", onClick = onPopBackStack, buttonType = ButtonType.OUTLINED)

                Spacer(modifier = Modifier.height(40.dp))
            }

        }
    }
}
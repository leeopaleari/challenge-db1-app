package br.com.fiap.mentora.ui.common.button

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.fiap.mentora.ui.theme.BackgroundDark
import br.com.fiap.mentora.ui.theme.MontserratBold
import br.com.fiap.mentora.ui.theme.PrimaryColor
import br.com.fiap.mentora.ui.theme.TextColorLight
import br.com.fiap.mentora.ui.theme.TextContrast

enum class ButtonType {
    SOLID,
    OUTLINED
}

@Composable
fun BaseButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    buttonType: ButtonType = ButtonType.SOLID
) {
    Button(
        modifier = modifier        ,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (buttonType == ButtonType.OUTLINED) BackgroundDark
            else PrimaryColor
        )
    ) {
        Text(
            text = text,
            color = if (buttonType == ButtonType.OUTLINED) TextColorLight else TextContrast,
            fontFamily = MontserratBold
        )
    }
}
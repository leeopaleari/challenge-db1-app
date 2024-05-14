package br.com.fiap.mentora.common.chip

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.fiap.mentora.ui.theme.PrimaryColor
import br.com.fiap.mentora.ui.theme.TextContrast

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomInputChip(
    text: String,
    onDismiss: () -> Unit,
) {
    var enabled by remember { mutableStateOf(false) }

    InputChip(
        onClick = {
            enabled = !enabled
        },
        label = { Text(text) },
        selected = enabled,
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
        avatar = {
            if (enabled) {
                Icon(
                    modifier = Modifier.size(20.dp),
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Localized description",
                )
            }
        },
//        trailingIcon = {
//            Icon(
//                imageVector = Icons.Default.Close,
//                contentDescription = "Localized description",
//                modifier = Modifier.size(InputChipDefaults.AvatarSize),
//            )
//        },
    )
}
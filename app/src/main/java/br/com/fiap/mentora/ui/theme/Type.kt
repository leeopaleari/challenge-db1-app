package br.com.fiap.mentora.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import br.com.fiap.mentora.R

val MontserratVariable = FontFamily(Font(R.font.montserrat_variable))
val MontserratBold = FontFamily(Font(R.font.montserrat_bold))
val MontserratSemiBold = FontFamily(Font(R.font.montserrat_semibold))
val MontserratRegular = FontFamily(Font(R.font.montserrat_regular))
val MontserratMedium = FontFamily(Font(R.font.montserrat_medium))

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = MontserratRegular,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
        color = TextColorPrimary
    ),
    // Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = MontserratBold,
        fontSize = 24.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp,
        color = TextColorTertiary,
    ),
    /*
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)
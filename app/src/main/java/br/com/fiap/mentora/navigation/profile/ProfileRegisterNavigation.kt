package br.com.fiap.mentora.navigation.profile

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.fiap.mentora.screens.auth.profile.ProfileRegisterScreen
import br.com.fiap.mentora.screens.auth.profile.YourHabilitiesScreen

const val profileRegisterRoute = "profileRegisterRoute"
const val yourHabilitiesRoute = "yourHabilitiesRoute"

fun NavHostController.navigateToProfileScreen() {
    navigate(profileRegisterRoute)
}

fun NavHostController.navigateYourHabilitiesScreen() {
    navigate(yourHabilitiesRoute)
}


fun NavGraphBuilder.profileRegisterScreen(
    navigateToYourHabilitiesScreen: () -> Unit
) {
    composable(profileRegisterRoute) {
        ProfileRegisterScreen(
            navigateToYourHabilitiesScreen = navigateToYourHabilitiesScreen
        )
    }
}

fun NavGraphBuilder.yourHabilitiesScreen() {
    composable(yourHabilitiesRoute) {
        YourHabilitiesScreen()
    }
}
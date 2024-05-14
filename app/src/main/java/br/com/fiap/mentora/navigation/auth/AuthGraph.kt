package br.com.fiap.mentora.navigation.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigation
import br.com.fiap.mentora.screens.auth.profile.navigation.navigateToProfileScreen
import br.com.fiap.mentora.screens.auth.profile.navigation.navigateYourHabilitiesScreen
import br.com.fiap.mentora.screens.auth.profile.navigation.profileRegisterScreen
import br.com.fiap.mentora.screens.auth.profile.navigation.yourHabilitiesScreen
import br.com.fiap.mentora.screens.auth.signIn.navigation.signInRoute
import br.com.fiap.mentora.screens.auth.signIn.navigation.signInScreen
import br.com.fiap.mentora.screens.auth.signUp.navigation.navigateToSignUpScreen
import br.com.fiap.mentora.screens.auth.signUp.navigation.signUpScreen

fun NavGraphBuilder.authGraph(
    navController: NavHostController,
) {
    navigation(route = "auth_graph", startDestination = signInRoute) {
        signInScreen(
            onNavigateToSignUpScreen = {
                navController.navigateToSignUpScreen()
            },
            onNavigateToAppScaffold = {
                navController.navigate("app_scaffold") {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }
        )

        signUpScreen(
            onPopBackStack = { navController.popBackStack() },
            onNavigateToProfileScreen = {
                navController.navigateToProfileScreen()
            },
        )

        profileRegisterScreen(
            navigateToYourHabilitiesScreen = { navController.navigateYourHabilitiesScreen() },
            onPopBackStack = { navController.popBackStack() }
        )

        yourHabilitiesScreen(
            onPopBackStack = { navController.popBackStack() }
        )

    }
}

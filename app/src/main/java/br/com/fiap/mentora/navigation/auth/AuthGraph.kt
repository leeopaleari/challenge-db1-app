package br.com.fiap.mentora.navigation.auth

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigation

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

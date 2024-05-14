package br.com.fiap.mentora.screens.app.profile.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.fiap.mentora.core.navigation.MentoraNavigationDestination
import br.com.fiap.mentora.screens.app.profile.ProfileScreen
import br.com.fiap.mentora.screens.auth.signIn.navigation.SignInDestination

object ProfileDestination : MentoraNavigationDestination {
    override val route = "profile_route"
    override val destination = "profile_destination"
}

fun NavGraphBuilder.profileGraph(
    navController: NavController,
    bottomBarVisibility: MutableState<Boolean>,
) {
    composable(route = ProfileDestination.route) {
        LaunchedEffect(null) {
            bottomBarVisibility.value = true
        }
        ProfileScreen(
            onLogout = {
                navController.navigate(SignInDestination.route)
            }
        )
    }
}
package br.com.fiap.mentora.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import br.com.fiap.mentora.screens.app.favorites.destination.FavoritesDestination
import br.com.fiap.mentora.screens.app.home.navigation.HomeDestination
import br.com.fiap.mentora.screens.app.profile.navigation.ProfileDestination
import br.com.fiap.mentora.screens.app.search.destination.SearchDestination

class MentoraTopLevelNavigation(private val navController: NavController) {
    fun navigateTo(destination: TopLevelDestination) {
        navController.navigate(destination.route) {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }
    }
}

data class TopLevelDestination(
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconText: String
)

val TOP_LEVEL_DESTINATIONS = listOf(
    TopLevelDestination(
        route = HomeDestination.route,
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        iconText = "Início"
    ),
    TopLevelDestination(
        route = SearchDestination.route,
        selectedIcon = Icons.Filled.Search,
        unselectedIcon = Icons.Outlined.Search,
        iconText = "Busca"
    ),
//    TopLevelDestination(
//        route = FavoritesDestination.route,
//        selectedIcon = Icons.Filled.Favorite,
//        unselectedIcon = Icons.Outlined.FavoriteBorder,
//        iconText = "Favoritos"
//    ),
    TopLevelDestination(
        route = ProfileDestination.route,
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Outlined.Person,
        iconText = "Perfil"
    ),
)
package br.com.fiap.mentora.ui.screens.app

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import br.com.fiap.mentora.navigation.mainGraph
import br.com.fiap.mentora.navigation.mainGraphRoute
import br.com.fiap.mentora.ui.theme.BackgroundDark
import br.com.fiap.mentora.ui.theme.PrimaryColor
import br.com.fiap.mentora.ui.theme.TextContrast

data class BottomNavigationItem(
    val title: String,
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val badgeCount: Int? = null
)

@Composable
fun AppScaffold(
    navController: NavController,
) {
    val navItems = listOf(
        BottomNavigationItem(
            title = "Início",
            route = "home_screen",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home
        ),
        BottomNavigationItem(
            title = "Busca",
            route = "search_screen",
            selectedIcon = Icons.Filled.Search,
            unselectedIcon = Icons.Outlined.Search
        ),
        BottomNavigationItem(
            title = "Favoritos",
            route = "favorites_screen",
            selectedIcon = Icons.Filled.Favorite,
            unselectedIcon = Icons.Outlined.FavoriteBorder
        ),
        BottomNavigationItem(
            title = "Perfil",
            route = "profile_screen",
            selectedIcon = Icons.Filled.Person,
            unselectedIcon = Icons.Outlined.Person
        ),
    )
    Scaffold(
        containerColor = BackgroundDark,
        bottomBar = {
            NavigationBar(
                containerColor = BackgroundDark,
                tonalElevation = 2.dp,
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                navItems.forEach { item ->
                    val isCurrentDestinationEqualRoute =
                        currentDestination?.hierarchy?.any { it.route == item.route }

                    NavigationBarItem(
                        selected = isCurrentDestinationEqualRoute == true,
                        onClick = {
                            navController.navigate(route = item.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        label = {
                            Text(text = item.title)
                        },
                        icon = {
                            Icon(
                                imageVector = if (isCurrentDestinationEqualRoute == true) item.selectedIcon else item.unselectedIcon,
                                contentDescription = item.title
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = TextContrast,
                            indicatorColor = PrimaryColor
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            NavHost(
                navController = navController as NavHostController,
                startDestination = mainGraphRoute
            ) {
                mainGraph(navController)
            }
        }
    }
}

package ant.realitresonance.clamness.presentation.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomBar(navController: NavHostController, isVisible: Boolean) {
    val items = listOf(
        BottomNavigationItems.ChatScreen,
        BottomNavigationItems.Descriptions
    )

    AnimatedVisibility(
        visible = isVisible,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it })
    ) {
        NavigationBar(
            containerColor = Color(0xFFFFFFFF)
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            items.forEach { item ->
                NavigationBarItem(
                    icon = { Icon(item.icon, contentDescription = item.title) },
                    label = { Text(text = item.title) },
                    selected = currentRoute == item.route,
                    onClick = {
                        navController.navigate(item.route) {
                            // Избегаем создания нескольких копий одного и того же пункта назначения
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            // Избегаем повторного нажатия на один и тот же пункт меню
                            launchSingleTop = true
                            // Восстанавливаем состояние при повторном выборе ранее выбранного элемента
                            restoreState = true
                        }
                    }
                )
            }
        }
    }
}
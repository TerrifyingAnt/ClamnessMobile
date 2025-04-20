package ant.realitresonance.clamness.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Nightlight
import androidx.compose.material.icons.filled.SelfImprovement
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationItems(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object ProfileScreen : BottomNavigationItems(
        route = Routes.Profile.route,
        title = "Профиль",
        icon = Icons.Default.AccountCircle
    )

    object ChatScreen : BottomNavigationItems(
        icon = Icons.Default.Chat,
        title = "Чаты",
        route = Routes.DoctorChat.route
    )

    object Descriptions : BottomNavigationItems(
        icon = Icons.Default.Description,
        title = "Отчеты",
        route = Routes.Description.route
    )

}
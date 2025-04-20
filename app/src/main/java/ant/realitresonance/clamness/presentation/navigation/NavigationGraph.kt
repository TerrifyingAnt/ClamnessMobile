package ant.realitresonance.clamness.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ant.realitresonance.clamness.presentation.doctor_screen.ChatScreen
import ant.realitresonance.clamness.presentation.doctor_screen.ChatViewModel
import ant.realitresonance.clamness.presentation.login_screen.LoginScreen
import ant.realitresonance.clamness.presentation.login_screen.LoginViewModel


@Composable
fun NavigationGraph(
    navController: NavHostController,
    onBottomVisibilityChanged: (Boolean) -> Unit
) {
        NavHost(navController, startDestination = Routes.DoctorChat.route) {

            // Чат врача (DEMO-экран)
            composable(Routes.DoctorChat.route) {
                onBottomVisibilityChanged(true)
                val viewModel = hiltViewModel<ChatViewModel>()
                ChatScreen(
                    viewModel = viewModel,
                    onNavigateToChat = { patientId ->
                        navController.navigate(Routes.PatientChatDetail.createRoute(patientId))
                    }
                )
            }

            composable(
                route = Routes.PatientChatDetail.route,
                arguments = listOf(navArgument("patient_id") {
                    type = NavType.IntType
                })
            ) { backStackEntry ->
                val patientId = backStackEntry.arguments?.getInt("patient_id") ?: return@composable
                onBottomVisibilityChanged(false)
                // PatientChatDetailScreen будет реализован позже
            }
        // Аутентификация
        composable(Routes.Login.route) {
            onBottomVisibilityChanged(false)
            val viewModel = hiltViewModel<LoginViewModel>()
            LoginScreen(
                viewModel = viewModel,
                onNavigateToRegister = { navController.navigate(Routes.Register.route) },
                onNavigateToForgotPassword = { },
                onNavigateToMain = {
                    navController.navigate(Routes.DoctorChat.route) {
                        popUpTo(Routes.Login.route) { inclusive = true }
                    }
                }
            )
        }
    }
}
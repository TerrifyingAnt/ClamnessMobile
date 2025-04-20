package ant.realitresonance.clamness.presentation.doctor_screen
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import ant.realitresonance.clamness.presentation.doctor_screen.components.ChatBottomBar
import ant.realitresonance.clamness.presentation.doctor_screen.components.ChatTopBar
import ant.realitresonance.clamness.presentation.doctor_screen.components.PatientList

@Composable
fun ChatScreen(
    viewModel: ChatViewModel = hiltViewModel(),
    onNavigateToChat: (Int) -> Unit
) {
    val chatState by viewModel.chatState

    Scaffold(
        topBar = { ChatTopBar() },
        bottomBar = { ChatBottomBar() }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            PatientList(
                patients = chatState.patients,
                onPatientClick = { patientId ->
                    onNavigateToChat(patientId)
                }
            )
        }
    }
}






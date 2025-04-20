package ant.realitresonance.clamness.presentation.doctor_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ant.realitresonance.clamness.presentation.doctor_screen.models.ChatState
import ant.realitresonance.clamness.presentation.doctor_screen.models.Patient
import ant.realitresonance.clamness.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
) : ViewModel() {

    private val _chatState = mutableStateOf(ChatState())
    val chatState: State<ChatState> = _chatState

    init {
        loadPatients()
    }

    private fun loadPatients() = viewModelScope.launch() {
                // В реальном приложении здесь был бы запрос к репозиторию
                // Для демонстрации используем моковые данные
                val mockPatients = listOf(
                    Patient(
                        id = 1,
                        name = "Пациенты онлайн",
                        hasPhoto = true,
                        lastMessageTime = "",
                        unreadCount = 0
                    ),
                    Patient(
                        id = 2,
                        name = "Геннадий Максимович",
                        hasPhoto = false,
                        lastMessageTime = "22:20 09/05",
                        unreadCount = 12
                    )
                )

                _chatState.value = ChatState(
                    patients = mockPatients,
                    patientsResult = Resource.success(mockPatients)
                )
        }
    }




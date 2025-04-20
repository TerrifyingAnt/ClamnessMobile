package ant.realitresonance.clamness.presentation.report_screen


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
class ReportsViewModel @Inject constructor(
) : ViewModel() {

    private val _state = MutableStateFlow(ReportsState())
    val state: StateFlow<ReportsState> = _state.asStateFlow()

    init {
        loadMockData()
    }

    private fun loadMockData() = {
        viewModelScope.launch() {
            _state.update { it.copy(patients = Resource.Loading()) }

            // Симуляция загрузки с бэкенда
            val mockPatients = listOf(
                PatientWithStates(
                    userId = 1,
                    name = "Иван Петров",
                    states = listOf(
                        EmotionalState(
                            emotionState = 0.8f,
                            physicalState = 0.7f,
                            description = "Отличное настроение",
                            date = LocalDateTime.now().minusDays(3),
                            reasons = listOf("Хорошая погода", "Успешный день"),
                            solution = "Продолжать позитивный настрой"
                        ),
                        EmotionalState(
                            emotionState = 0.5f,
                            physicalState = 0.6f,
                            description = "Нормальное состояние",
                            date = LocalDateTime.now().minusDays(2),
                            reasons = listOf("Обычный день"),
                            solution = "Отдых"
                        ),
                        EmotionalState(
                            emotionState = 0.3f,
                            physicalState = 0.4f,
                            description = "Плохое настроение",
                            date = LocalDateTime.now().minusDays(1),
                            reasons = listOf("Стресс на работе", "Недосып"),
                            solution = "Медитация, ранний сон"
                        )
                    )
                ),
                PatientWithStates(
                    userId = 2,
                    name = "Анна Сидорова",
                    states = listOf(
                        EmotionalState(
                            emotionState = 0.7f,
                            physicalState = 0.8f,
                            description = "Хорошее настроение",
                            date = LocalDateTime.now().minusDays(4),
                            reasons = listOf("Успешное завершение проекта"),
                            solution = "Продолжать в том же духе"
                        ),
                        EmotionalState(
                            emotionState = 0.9f,
                            physicalState = 0.8f,
                            description = "Очень хорошее настроение",
                            date = LocalDateTime.now().minusDays(2),
                            reasons = listOf("Повышение на работе", "Поездка в отпуск"),
                            solution = "Наслаждаться моментом"
                        )
                    )
                )
            )

            _state.update { it.copy(patients = Resource.Success(mockPatients)) }
        }
    }

    fun selectPatient(patientId: Int) {
        _state.update { it.copy(selectedPatientId = patientId) }
    }
}


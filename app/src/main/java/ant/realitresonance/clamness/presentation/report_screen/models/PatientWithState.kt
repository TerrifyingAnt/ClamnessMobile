package ant.realitresonance.clamness.presentation.report_screen.models


/**
 * Модель, группирующая состояния пользователя по пациентам
 */
data class PatientWithStates(
    val patientId: Long,
    val patientName: String,
    val userStates: List<UserState>
)
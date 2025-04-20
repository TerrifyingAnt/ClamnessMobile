package ant.realitresonance.clamness.presentation.report_screen.models

import java.time.LocalDateTime

/**
 * Модель данных состояния пользователя согласно структуре БД
 */
data class UserState(
    val id: Long,
    val userId: Long,
    val emotionState: Float,
    val physicalState: Float,
    val description: String?,
    val date: LocalDateTime,
    val reasons: String,
    val solution: String
)

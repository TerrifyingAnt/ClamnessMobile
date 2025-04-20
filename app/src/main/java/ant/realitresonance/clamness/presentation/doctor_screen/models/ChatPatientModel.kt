package ant.realitresonance.clamness.presentation.doctor_screen.models

data class Patient(
    val id: Int,
    val name: String,
    val hasPhoto: Boolean,
    val lastMessageTime: String,
    val unreadCount: Int
)
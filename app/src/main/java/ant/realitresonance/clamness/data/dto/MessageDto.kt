package ant.realitresonance.clamness.data.dto

data class MessageDto(
    val id: Int = -1,
    val content: String? = "",
    val mediaLink: String? = "",
    val fromUser: Int? = -1
)
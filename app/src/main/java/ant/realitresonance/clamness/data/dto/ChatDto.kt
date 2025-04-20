package ant.realitresonance.clamness.data.dto

data class ChatDto(
    val chatId: Int = -1,
    val lastMessage: MessageDto? = null,
    val name: String = ""
)

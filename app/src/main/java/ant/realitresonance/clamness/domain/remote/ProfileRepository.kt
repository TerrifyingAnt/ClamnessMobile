package ant.realitresonance.clamness.domain.remote

import ant.realitresonance.clamness.data.dto.ChatDto
import ant.realitresonance.clamness.utils.Resource

interface IProfileRepository {
    suspend fun getChats(): Resource<List<ChatDto>>

}
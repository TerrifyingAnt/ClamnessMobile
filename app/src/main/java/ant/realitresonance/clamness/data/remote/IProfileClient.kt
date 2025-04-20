package ant.realitresonance.clamness.data.remote

import ant.realitresonance.clamness.data.dto.ChatDto
import retrofit2.Response
import retrofit2.http.GET

interface IProfileClient {

    @GET("/users/chats")
    suspend fun getChats(): Response<List<ChatDto>>
}
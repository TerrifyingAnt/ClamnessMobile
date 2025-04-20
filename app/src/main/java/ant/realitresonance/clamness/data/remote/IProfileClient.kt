package ant.realitresonance.clamness.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface IProfileClient {
    @GET("/users/{user-id}")
    suspend fun getUserInfo(): Response<UserDetailsDto>
}
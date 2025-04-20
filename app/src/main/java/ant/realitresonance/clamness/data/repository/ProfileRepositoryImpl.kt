package ant.realitresonance.clamness.data.repository

import ant.realitresonance.clamness.data.dto.ChatDto
import ant.realitresonance.clamness.data.remote.BaseDataSource
import ant.realitresonance.clamness.data.remote.IProfileClient
import ant.realitresonance.clamness.domain.remote.IProfileRepository
import ant.realitresonance.clamness.utils.Resource
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val iProfileClient: IProfileClient
) : BaseDataSource(), IProfileRepository {
    override suspend fun getChats(): Resource<List<ChatDto>> {
        return safeApiCall { iProfileClient.getChats() }
    }
}
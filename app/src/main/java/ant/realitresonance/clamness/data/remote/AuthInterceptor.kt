package ant.realitresonance.clamness.data.remote


import ant.realitresonance.clamness.data.local.TokenManager
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthInterceptor @Inject constructor(
    private val tokenManager: TokenManager
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = runBlocking {
            tokenManager.getAccessToken().first()
        }

        val originalRequest = chain.request()
        val isExcludedUrl = isUrlExcluded(originalRequest.url)

        if (!isExcludedUrl) {
            val authorizedRequest = originalRequest.newBuilder()
                .header("Authorization", "Bearer $token")
                .build()

            return chain.proceed(authorizedRequest)
        }

        return chain.proceed(originalRequest)
    }

    private fun isUrlExcluded(url: HttpUrl): Boolean {
        // Add your logic to check if the URL should be excluded
        val excludedPaths = listOf("/gh-user-data-storage", "/gh-main-storage", "/login", "/register")
        return excludedPaths.any { url.encodedPath.startsWith(it) }
    }
}
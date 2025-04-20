package ant.realitresonance.clamness.di

import ant.realitresonance.clamness.data.remote.AuthInterceptor
import ant.realitresonance.clamness.data.remote.IProfileClient
import ant.realitresonance.clamness.data.repository.ProfileRepositoryImpl
import ant.realitresonance.clamness.domain.remote.IProfileRepository
import ant.realitresonance.clamness.utils.Constants
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptor: AuthInterceptor) =
        OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_MAIN_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    @Singleton
    fun provideFiguresClient(retrofit: Retrofit): IProfileClient =
        retrofit.create(IProfileClient::class.java)

    @Provides
    @Singleton
    fun provideIFiguresClient(iProfileClient: IProfileClient): IProfileRepository =
        ProfileRepositoryImpl(iProfileClient)
}
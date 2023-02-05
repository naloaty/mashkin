package me.naloaty.fintechmovies.di.app

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import me.naloaty.fintechmovies.BuildConfig
import me.naloaty.fintechmovies.data.api.ApiKeyAuthInterceptor
import me.naloaty.fintechmovies.data.api.KinopoiskService
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

private const val KINOPOISK_BASE_URL = "https://kinopoiskapiunofficial.tech/"

@Module
class RetrofitModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder()
            .addInterceptor(ApiKeyAuthInterceptor(BuildConfig.KINOPOISK_API_KEY))
            .build()
    }

    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val mediaType = "application/json".toMediaType()

        return Retrofit.Builder()
            .baseUrl(KINOPOISK_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(Json.asConverterFactory(mediaType))
            .build()
    }

    @Provides
    @Singleton
    fun provideKinopoiskService(retrofit: Retrofit): KinopoiskService {
        return retrofit.create(KinopoiskService::class.java)
    }
}
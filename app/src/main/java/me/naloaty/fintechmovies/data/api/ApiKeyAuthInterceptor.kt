package me.naloaty.fintechmovies.data.api

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyAuthInterceptor(
    private val apiKey: String
): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader(API_KEY_HEADER, apiKey)
            .build()

        return chain.proceed(request)
    }

    companion object {
        private const val API_KEY_HEADER = "X-Api-Key"
    }
}
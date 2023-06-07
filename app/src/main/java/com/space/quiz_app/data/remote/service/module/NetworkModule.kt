package com.space.quiz_app.data.remote.service.module

import com.space.quiz_app.data.remote.service.api.QuizServiceApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://run.mocky.io"

private fun createRetrofit(): Retrofit {
    return Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

private fun provideService(retrofit: Retrofit): QuizServiceApi =
    retrofit.create(QuizServiceApi::class.java)

val networkModule = module {
    single { createRetrofit() }
    single { provideService(get()) }
}
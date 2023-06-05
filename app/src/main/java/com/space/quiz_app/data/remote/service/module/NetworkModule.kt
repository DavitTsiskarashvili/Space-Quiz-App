package com.space.quiz_app.data.remote.service.module

import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

    private const val BASE_URL = "https://run.mocky.io/"

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val networkModule = module {
        single { createRetrofit() }
    }
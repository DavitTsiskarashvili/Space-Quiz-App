package com.space.quiz_app.data.remote.service.api

import com.space.quiz_app.data.remote.model.QuizQuestionsDTO
import retrofit2.Response
import retrofit2.http.GET

interface QuizServiceApi {
    @GET("/v3/73a800bf-fb55-4aae-8db7-12841a65579e")
    suspend fun getSubjects(): Response<QuizQuestionsDTO>
}
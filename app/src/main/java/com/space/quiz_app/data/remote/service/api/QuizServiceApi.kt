package com.space.quiz_app.data.remote.service.api

import com.space.quiz_app.data.remote.model.QuizQuestionsDTO
import retrofit2.Response
import retrofit2.http.GET

interface QuizServiceApi {
    @GET("/v3/9a2cbd2f-d77c-498a-a410-91351fe42577")
    suspend fun getSubjects(): Response<List<QuizQuestionsDTO>>
}
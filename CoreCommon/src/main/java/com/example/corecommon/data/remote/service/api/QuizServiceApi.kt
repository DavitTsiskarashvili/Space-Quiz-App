package com.example.corecommon.data.remote.service.api

import com.example.corecommon.data.remote.model.QuizSubjectDTO
import retrofit2.Response
import retrofit2.http.GET

interface QuizServiceApi {
    @GET("/v3/8ade4e0b-bee1-4eae-a98b-47edeea68324")
    suspend fun getSubjects(): Response<List<QuizSubjectDTO>>
}
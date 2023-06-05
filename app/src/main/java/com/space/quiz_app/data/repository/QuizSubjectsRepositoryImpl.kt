package com.space.quiz_app.data.repository

import com.space.quiz_app.data.remote.model.QuizQuestionsDTO
import com.space.quiz_app.data.remote.service.api.QuizServiceApi
import com.space.quiz_app.data.remote.service.result_handler.retrofit.apiDataFetcher
import com.space.quiz_app.domain.repository.QuizSubjectsRepository

class QuizSubjectsRepositoryImpl(
    private val fetchSubjects: QuizServiceApi
): QuizSubjectsRepository {
    override suspend fun getSubjects(): QuizQuestionsDTO {
        return apiDataFetcher { fetchSubjects.getSubjects() }
    }
}
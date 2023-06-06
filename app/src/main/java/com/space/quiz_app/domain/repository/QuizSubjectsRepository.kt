package com.space.quiz_app.domain.repository

import com.space.quiz_app.data.remote.model.QuizQuestionsDTO
import com.space.quiz_app.data.remote.service.result_handler.resource.Resource
import com.space.quiz_app.domain.model.questions.QuizQuestionsDomainModel
import retrofit2.Response

interface QuizSubjectsRepository {
    suspend fun getSubjects(): Resource<List<QuizQuestionsDomainModel>>
}
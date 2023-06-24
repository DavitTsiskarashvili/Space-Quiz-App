package com.space.quiz_app.domain.repository

import com.space.quiz_app.data.remote.service.result_handler.resource.Resource
import com.space.quiz_app.domain.model.questions.QuizQuestionDomainModel

interface QuizSubjectsRepository {
    suspend fun getSubjects(): Resource<List<QuizQuestionDomainModel>>
}
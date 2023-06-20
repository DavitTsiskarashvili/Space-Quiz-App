package com.domain.repository

import com.data.remote.service.result_handler.resource.Resource
import com.domain.model.questions.QuizQuestionsDomainModel

interface QuizSubjectsRepository {
    suspend fun getSubjects(): Resource<List<QuizQuestionsDomainModel>>
}
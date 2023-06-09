package com.space.quiz_app.data.repository

import com.space.quiz_app.data.remote.mapper.QuizQuestionsDTOMapper
import com.space.quiz_app.data.remote.service.api.QuizServiceApi
import com.space.quiz_app.data.remote.service.result_handler.resource.Resource
import com.space.quiz_app.data.remote.service.result_handler.retrofit.apiDataFetcher
import com.space.quiz_app.domain.model.questions.QuizQuestionsDomainModel
import com.space.quiz_app.domain.repository.QuizSubjectsRepository

class QuizSubjectsRepositoryImpl(
    private val fetchSubjects: QuizServiceApi,
    private val quizQuestionsDomainMapper: QuizQuestionsDTOMapper
): QuizSubjectsRepository {
    override suspend fun getSubjects(): Resource<List<QuizQuestionsDomainModel>> {
        return apiDataFetcher (
            {subjectDTO -> subjectDTO.map {quizQuestionsDomainMapper(it)}},
            { fetchSubjects.getSubjects() }
        )
    }
}
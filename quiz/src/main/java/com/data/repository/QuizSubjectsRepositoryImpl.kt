package com.data.repository

import com.data.remote.mapper.QuizQuestionsDTOMapper
import com.data.remote.service.api.QuizServiceApi
import com.data.remote.service.result_handler.resource.Resource
import com.data.remote.service.result_handler.retrofit.apiDataFetcher
import com.domain.model.questions.QuizQuestionsDomainModel
import com.domain.repository.QuizSubjectsRepository

class QuizSubjectsRepositoryImpl(
    private val fetchSubjects: QuizServiceApi,
    private val quizQuestionsDomainMapper: QuizQuestionsDTOMapper
) : QuizSubjectsRepository {
    override suspend fun getSubjects(): Resource<List<QuizQuestionsDomainModel>> {
        return apiDataFetcher(
            { subjectDTO -> subjectDTO.map { quizQuestionsDomainMapper(it) } },
            { fetchSubjects.getSubjects() }
        )
    }
}
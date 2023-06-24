package com.space.quiz_app.data.repository

import com.space.quiz_app.data.local.dao.QuizQuestionsDao
import com.space.quiz_app.data.local.dao.QuizSubjectsDao
import com.space.quiz_app.data.mapper.question.QuizQuestionDomainToEntityMapper
import com.space.quiz_app.data.mapper.question.QuizQuestionEntityToDomainMapper
import com.space.quiz_app.data.mapper.subject.QuizSubjectDomainToEntityMapper
import com.space.quiz_app.data.mapper.subject.QuizSubjectEntityToDomainMapper
import com.space.quiz_app.data.remote.mapper.QuizQuestionsDTOMapper
import com.space.quiz_app.data.remote.model.QuizSubjectDTO
import com.space.quiz_app.data.remote.service.api.QuizServiceApi
import com.space.quiz_app.data.remote.service.result_handler.resource.Resource
import com.space.quiz_app.data.remote.service.result_handler.retrofit.apiDataFetcher
import com.space.quiz_app.domain.model.questions.QuizQuestionDomainModel
import com.space.quiz_app.domain.model.subject.QuizSubjectDomainModel
import com.space.quiz_app.domain.repository.QuizSubjectsRepository

class QuizSubjectsRepositoryImpl(
    private val fetchSubjects: QuizServiceApi,
    private val subjectsDao: QuizSubjectsDao,
    private val questionsDao: QuizQuestionsDao,
    private val subjectDtoMapper: QuizSubjectEntityToDomainMapper,
    private val QuizSubjectDomainToEntityMapper: QuizSubjectDomainToEntityMapper,
) : QuizSubjectsRepository {
    override suspend fun getSubjectsFromNetwork(): List<QuizSubjectDomainModel> {
        val remoteData = apiDataFetcher { fetchSubjects.getSubjects() }
        if (remoteData is Resource.Success) {
            saveDataToLocal(remoteData.data)
        }
        return getSubjectsFromDatabase()
    }

    override suspend fun getSubjectsFromDatabase(): List<QuizSubjectDomainModel> {
        return subjectsDao.getAllSubject().map { subjectDtoMapper(it) }
    }

    private suspend fun saveDataToLocal (remoteData: List<QuizSubjectDTO>) {

    }
}
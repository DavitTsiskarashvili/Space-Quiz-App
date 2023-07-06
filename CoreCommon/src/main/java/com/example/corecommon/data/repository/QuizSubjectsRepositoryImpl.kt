package com.example.corecommon.data.repository

import com.example.corecommon.data.local.dao.QuizQuestionsDao
import com.example.corecommon.data.local.dao.QuizSubjectsDao
import com.example.corecommon.data.mapper.subject.QuizSubjectEntityToDomainMapper
import com.example.corecommon.data.remote.mapper.QuizQuestionsDTOMapper
import com.example.corecommon.data.remote.mapper.QuizSubjectDTOMapper
import com.example.corecommon.data.remote.model.QuizSubjectDTO
import com.example.corecommon.data.remote.service.api.QuizServiceApi
import com.example.corecommon.data.remote.service.result_handler.resource.Resource
import com.example.corecommon.data.remote.service.result_handler.retrofit.apiDataFetcher
import com.example.corecommon.domain.model.subject.QuizSubjectDomainModel
import com.example.corecommon.domain.repository.QuizSubjectsRepository

class QuizSubjectsRepositoryImpl(
    private val fetchSubjects: QuizServiceApi,
    private val subjectsDao: QuizSubjectsDao,
    private val questionsDao: QuizQuestionsDao,
    private val subjectDTOMapper: QuizSubjectDTOMapper,
    private val subjectEntityMapper: QuizSubjectEntityToDomainMapper,
    private val questionDTOMapper: QuizQuestionsDTOMapper
) : QuizSubjectsRepository {
    override suspend fun getSubjectsFromNetwork(): List<QuizSubjectDomainModel> {
        val remoteData = apiDataFetcher { fetchSubjects.getSubjects() }
        if (remoteData is Resource.Success) {
            saveDataToLocal(remoteData.data)
        }
        return getSubjectsFromDatabase()
    }

    override suspend fun getSubjectsFromDatabase(): List<QuizSubjectDomainModel> {
        return subjectsDao.getAllSubject().map { subjectEntityMapper(it) }
    }

    private suspend fun saveDataToLocal(remoteData: List<QuizSubjectDTO>) {

        val quizSubjects = remoteData.map { subjectDTOMapper(it) }
        subjectsDao.insertSubjects(quizSubjects)

        val quizQuestions = remoteData.map {
            it.questions.map { question ->
                questionDTOMapper.subjectTitle = { it.quizTitle }
                questionDTOMapper(question)
            }
        }

        quizQuestions.forEach {
            questionsDao.insertQuestion(it)
        }
    }
}
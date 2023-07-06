package com.space.quiz_app.data.repository

import com.space.quiz_app.data.local.dao.QuizQuestionsDao
import com.space.quiz_app.data.local.dao.QuizSubjectsDao
import com.space.quiz_app.data.mapper.subject.QuizSubjectEntityToDomainMapper
import com.space.quiz_app.data.remote.mapper.QuizQuestionsDTOMapper
import com.space.quiz_app.data.remote.mapper.QuizSubjectDTOMapper
import com.space.quiz_app.data.remote.model.QuizSubjectDTO
import com.space.quiz_app.data.remote.service.api.QuizServiceApi
import com.space.quiz_app.data.remote.service.result_handler.resource.Resource
import com.space.quiz_app.data.remote.service.result_handler.retrofit.apiDataFetcher
import com.space.quiz_app.domain.model.subject.QuizSubjectDomainModel
import com.space.quiz_app.domain.repository.QuizSubjectsRepository

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
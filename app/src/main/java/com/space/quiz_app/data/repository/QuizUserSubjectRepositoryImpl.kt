package com.space.quiz_app.data.repository

import com.space.quiz_app.data.local.dao.QuizUserSubjectsDao
import com.space.quiz_app.data.local.entity.QuizUserSubjectEntity
import com.space.quiz_app.data.mapper.user.QuizUserSubjectsDomainToEntityMapper
import com.space.quiz_app.data.mapper.user.QuizUserSubjectsEntityToDomainMapper
import com.space.quiz_app.domain.model.subject.QuizSubjectDomainModel
import com.space.quiz_app.domain.repository.QuizUserSubjectsRepository
import com.space.quiz_app.presentation.feature.model.subject.QuizSubjectUIModel

class QuizUserSubjectRepositoryImpl(
    private val userSubjectsDao: QuizUserSubjectsDao,
    private val userSubjectEntityToDomain: QuizUserSubjectsEntityToDomainMapper,
    private val userSubjectDomainToEntity: QuizUserSubjectsDomainToEntityMapper
) : QuizUserSubjectsRepository {

    override suspend fun insertUserSubject(userSubject: QuizUserSubjectEntity) {
        userSubjectsDao.insertUserSubject(userSubject)
    }

    override suspend fun getUserSpecificSubject(
        username: String,
        quizTitle: String
    ): QuizUserSubjectEntity? {
        return userSubjectsDao.getUserSpecificSubject(username, quizTitle)
    }


    override suspend fun updateUserSubject(userSubject: QuizUserSubjectEntity) {
        userSubjectsDao.updateUserSubject(userSubject)
    }

    override suspend fun saveUserScore(
        username: String,
        score: Int,
        subject: QuizSubjectDomainModel
    ) {
        val userSubject = getUserSpecificSubject(username, subject.quizTitle)
        if (userSubject == null) {
            insertUserSubject(
                QuizUserSubjectEntity(
                    username = username,
                    quizTitle = subject.quizTitle,
                    score = score,
                    quizIcon = subject.quizIcon,
                    quizDescription = subject.quizDescription
                )
            )
        } else if (userSubject.score <= score) {
            updateUserSubject(userSubject.copy(score = score))
        }
    }

}
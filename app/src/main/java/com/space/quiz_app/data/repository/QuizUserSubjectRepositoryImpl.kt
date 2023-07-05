package com.space.quiz_app.data.repository

import com.space.quiz_app.data.local.dao.QuizUserSubjectsDao
import com.space.quiz_app.data.local.entity.QuizUserSubjectEntity
import com.space.quiz_app.data.mapper.user.QuizUserSubjectsEntityToDomainMapper
import com.space.quiz_app.domain.model.subject.QuizSubjectDomainModel
import com.space.quiz_app.domain.model.user.QuizUserSubjectsDomainModel
import com.space.quiz_app.domain.repository.QuizUserSubjectsRepository

class QuizUserSubjectRepositoryImpl(
    private val userSubjectsDao: QuizUserSubjectsDao,
    private val userSubjectsEntityToDomainMapper: QuizUserSubjectsEntityToDomainMapper
) : QuizUserSubjectsRepository {

    override suspend fun insertUserSubject(userSubject: QuizUserSubjectEntity) {
        userSubjectsDao.insertUserSubject(userSubject)
    }

    override suspend fun getUserSubjectByTitle(
        username: String,
        quizTitle: String
    ): QuizUserSubjectEntity? {
        return userSubjectsDao.getUserSubjectByTitle(username, quizTitle)
    }

    override suspend fun getUserSubjects(username: String): List<QuizUserSubjectsDomainModel> {
        return userSubjectsDao.getUserSubjects(username)
            .map { userSubjectsEntityToDomainMapper(it) }
    }

    override suspend fun updateUserSubject(userSubject: QuizUserSubjectEntity) {
        userSubjectsDao.updateUserSubject(userSubject)
    }

    override suspend fun saveUserScore(
        username: String,
        score: Int,
        subject: QuizSubjectDomainModel
    ) {
        val userSubject = getUserSubjectByTitle(username, subject.quizTitle)
        if (userSubject == null) {
            insertUserSubject(
                QuizUserSubjectEntity(
                    username = username,
                    quizTitle = subject.quizTitle,
                    score = score,
                    quizIcon = subject.quizIcon,
                    quizDescription = subject.quizDescription,
                    questionsCount = subject.questionsCount
                )
            )
        } else if (userSubject.score <= score) {
            updateUserSubject(userSubject.copy(score = score))
        }
    }

}
package com.space.quiz_app.data.repository

import com.space.quiz_app.data.local.QuizUserDao
import com.space.quiz_app.data.mapper.QuizUserDomainToEntityMapper
import com.space.quiz_app.data.mapper.QuizUserEntityToDomainMapper
import com.space.quiz_app.domain.model.QuizUserDomainModel
import com.space.quiz_app.domain.repository.QuizUserRepository

class QuizUserRepositoryImpl(
    private val userDao: QuizUserDao,
    private val quizUserDomainModelToEntityMapper: QuizUserDomainToEntityMapper,
) : QuizUserRepository {

    override suspend fun insertUsername(username: QuizUserDomainModel) {
        userDao.insertUser(quizUserDomainModelToEntityMapper(username))
    }

    override suspend fun isUsernameRegistered(username: String): Boolean {
        return userDao.isUsernameRegistered(username)
    }
}
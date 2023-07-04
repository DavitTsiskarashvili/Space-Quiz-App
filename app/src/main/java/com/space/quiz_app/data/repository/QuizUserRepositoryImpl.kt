package com.space.quiz_app.data.repository

import com.space.quiz_app.data.local.dao.QuizUserDao
import com.space.quiz_app.data.mapper.user.QuizUserDomainToEntityMapper
import com.space.quiz_app.data.mapper.user.QuizUserEntityToDomainMapper
import com.space.quiz_app.domain.model.user.QuizUserDomainModel
import com.space.quiz_app.domain.repository.QuizUserRepository

class QuizUserRepositoryImpl(
    private val userDao: QuizUserDao,
    private val quizUserDomainModelToEntityMapper: QuizUserDomainToEntityMapper,
    private val quizUserEntityToDomainMapper: QuizUserEntityToDomainMapper
) : QuizUserRepository {

    override suspend fun insertUsername(username: QuizUserDomainModel) {
        userDao.insertUser(quizUserDomainModelToEntityMapper(username))
    }

    override suspend fun isUsernameRegistered(username: String): Boolean {
        return userDao.isUsernameRegistered(username)
    }

    override suspend fun getUsernameIfLoggedIn(): QuizUserDomainModel? {
        val userEntity = userDao.getUsernameIfLoggedIn()
        return userEntity?.let { quizUserEntityToDomainMapper(it) }
    }
}



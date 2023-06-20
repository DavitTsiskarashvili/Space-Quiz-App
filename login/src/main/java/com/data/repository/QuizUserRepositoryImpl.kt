package com.data.repository

import com.data.local.QuizUserDao
import com.data.mapper.QuizUserDomainToEntityMapper
import com.data.mapper.QuizUserEntityToDomainMapper
import com.domain.model.QuizUserDomainModel
import com.domain.repository.QuizUserRepository

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



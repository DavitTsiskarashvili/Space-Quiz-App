package com.space.quiz_app.data.repository

import android.os.Build.VERSION_CODES.Q
import com.space.quiz_app.data.local.QuizUserDao
import com.space.quiz_app.data.local.QuizUserEntity
import com.space.quiz_app.data.mapper.QuizUserDomainModelToEntityMapper
import com.space.quiz_app.data.mapper.QuizUserEntityToDomainMapper
import com.space.quiz_app.domain.model.QuizUserDomainModel
import com.space.quiz_app.domain.repository.QuizUserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class QuizUserRepositoryImpl(
    private val userDao: QuizUserDao,
    private val quizUserDomainModelToEntityMapper: QuizUserDomainModelToEntityMapper,
    private val quizUserEntityToDomainMapper: QuizUserEntityToDomainMapper
) : QuizUserRepository {

    override suspend fun insertUsername(username: QuizUserDomainModel) {
        userDao.insertUser(quizUserDomainModelToEntityMapper(username))
    }

    override suspend fun getUsername(username: String): String {
        return userDao.getUsername(username)

    }

    override suspend fun isUsernameRegistered(username: String): Boolean {
        return userDao.isUsernameRegistered(username)
    }

}



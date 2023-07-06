package com.example.corecommon.data.repository

import com.example.corecommon.data.local.dao.QuizUserDao
import com.example.corecommon.data.mapper.user.QuizUserDomainToEntityMapper
import com.example.corecommon.data.mapper.user.QuizUserEntityToDomainMapper
import com.example.corecommon.domain.model.user.QuizUserDomainModel
import com.example.corecommon.domain.repository.QuizUserRepository

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

    override suspend fun saveGPA(username: String, gpa: Float) {
        userDao.insertUser(userDao.getCurrentUser(username).copy(gpa = gpa))
    }

    override suspend fun loginUser(username: String) {
        if (isUsernameRegistered(username)) {
           userDao.updateUserActiveStatus(username, true)
        } else {
            insertUsername(QuizUserDomainModel(username, gpa = 0f, isLoggedIn = true))
        }
    }

}
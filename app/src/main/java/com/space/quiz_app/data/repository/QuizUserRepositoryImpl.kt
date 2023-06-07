package com.space.quiz_app.data.repository

import com.space.quiz_app.data.local.QuizUserDao
import com.space.quiz_app.data.mapper.user.QuizUserDomainToEntityMapper
import com.space.quiz_app.data.mapper.user.QuizUserEntityToDomainMapper
import com.space.quiz_app.domain.model.user.QuizUserDomainModel
import com.space.quiz_app.domain.repository.QuizUserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

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

    override suspend fun getEntityIfLoggedIn(): Flow<QuizUserDomainModel?> =
        flow {
            val userEntity = userDao.getEntityIfLoggedIn()
            if( userEntity.isEmpty()){
                emit(null)
            } else {
                emit(quizUserEntityToDomainMapper(userEntity[0]))
            }
        }

    override suspend fun getEntity(username: String): Flow<QuizUserDomainModel> =
        flow {
            emit(quizUserEntityToDomainMapper(userDao.getEntity(username)[0]))
        }
}



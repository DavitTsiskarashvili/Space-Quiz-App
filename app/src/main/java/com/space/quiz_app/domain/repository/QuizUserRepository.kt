package com.space.quiz_app.domain.repository

import com.space.quiz_app.domain.model.QuizUserDomainModel
import kotlinx.coroutines.flow.Flow

interface QuizUserRepository {
    suspend fun insertUsername(username: QuizUserDomainModel)

    suspend fun isUsernameRegistered(username: String): Boolean

    suspend fun getEntityIfLoggedIn(): Flow<QuizUserDomainModel?>

    suspend fun getEntity(username: String): Flow<QuizUserDomainModel>
}
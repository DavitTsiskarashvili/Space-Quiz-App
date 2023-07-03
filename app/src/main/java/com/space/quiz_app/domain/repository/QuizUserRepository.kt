package com.space.quiz_app.domain.repository

import com.space.quiz_app.domain.model.user.QuizUserDomainModel
import kotlinx.coroutines.flow.Flow

interface QuizUserRepository {
    suspend fun insertUsername(username: QuizUserDomainModel)

    suspend fun isUsernameRegistered(username: String): Boolean

    suspend fun getUsernameIfLoggedIn(): QuizUserDomainModel?
}
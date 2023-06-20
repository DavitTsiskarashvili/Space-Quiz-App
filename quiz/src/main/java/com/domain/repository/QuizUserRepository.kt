package com.domain.repository

import com.domain.model.user.QuizUserDomainModel

interface QuizUserRepository {
    suspend fun insertUsername(username: QuizUserDomainModel)

    suspend fun isUsernameRegistered(username: String): Boolean

    suspend fun getUsernameIfLoggedIn(): QuizUserDomainModel?
}
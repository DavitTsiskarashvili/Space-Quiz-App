package com.space.quiz_app.domain.repository

import com.space.quiz_app.domain.model.QuizUserDomainModel

interface QuizUserRepository {
    suspend fun insertUsername(username: QuizUserDomainModel)

    suspend fun getUsername(username: String): String

    suspend fun isUsernameRegistered(username: String): Boolean
}
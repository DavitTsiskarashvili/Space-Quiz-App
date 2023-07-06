package com.example.corecommon.domain.repository

import com.example.corecommon.domain.model.user.QuizUserDomainModel

interface QuizUserRepository {
    suspend fun insertUsername(username: QuizUserDomainModel)

    suspend fun isUsernameRegistered(username: String): Boolean

    suspend fun getUsernameIfLoggedIn(): QuizUserDomainModel?

    suspend fun saveGPA(username: String, gpa: Float)

    suspend fun loginUser(username: String)
}
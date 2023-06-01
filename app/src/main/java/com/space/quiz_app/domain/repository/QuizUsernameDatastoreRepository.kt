package com.space.quiz_app.domain.repository

import kotlinx.coroutines.flow.Flow

interface QuizUsernameDatastoreRepository {
    suspend fun saveUsername(username: String)
    suspend fun getUsername(): Flow<String>
}
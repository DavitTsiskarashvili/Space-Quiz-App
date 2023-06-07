package com.space.quiz_app.data.repository

import com.space.quiz_app.data.datastore.QuizUserDatastore
import com.space.quiz_app.domain.repository.QuizUsernameDatastoreRepository
import kotlinx.coroutines.flow.Flow

class QuizUsernameRepositoryImpl(
    private val quizDatastoreManager: QuizUserDatastore
) : QuizUsernameDatastoreRepository {
    override suspend fun saveUsername(username: String) {
        quizDatastoreManager.saveValue(username)
    }

    override suspend fun getUsername(): Flow<String> =
        quizDatastoreManager.getValue()
}
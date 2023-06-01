package com.space.quiz_app.data.datastore

import kotlinx.coroutines.flow.Flow

interface QuizDatastoreManager<T : Any> {
    suspend fun saveValue(value: T)
    suspend fun getValue(): Flow<T>
}
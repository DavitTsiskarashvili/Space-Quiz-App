package com.space.quiz_app.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface QuizUserDao {
    @Query("SELECT * FROM User_table")
    fun getAllUser(): Flow<List<QuizUserEntity>>

    @Insert
    suspend fun insertUser(userName: QuizUserEntity)
}
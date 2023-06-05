package com.space.quiz_app.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface QuizUserDao {
    @Query("SELECT EXISTS(SELECT * FROM User_Table WHERE username = :username)")
    suspend fun isUsernameRegistered(user: String): Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: QuizUserEntity)
}
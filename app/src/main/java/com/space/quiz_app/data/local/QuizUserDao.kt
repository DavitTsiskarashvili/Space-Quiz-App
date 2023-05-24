package com.space.quiz_app.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface QuizUserDao {
    @Query("SELECT EXISTS(SELECT * FROM User_table WHERE username = :username)")
    suspend fun isUsernameRegistered(username: String): Boolean

    @Query("select * from User_table where username = :username")
    suspend fun getUsername(username: String): String

    @Insert
    suspend fun insertUser(username: QuizUserEntity)
}
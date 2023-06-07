package com.space.quiz_app.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface QuizUserDao {
    @Query("SELECT EXISTS(SELECT * FROM User_table WHERE username = :username)")
    suspend fun isUsernameRegistered(username: String): Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(username: QuizUserEntity)

    @Query("SELECT * FROM User_table WHERE isLoggedIn = true")
    suspend fun getEntityIfLoggedIn(): QuizUserEntity?

    @Query("SELECT * FROM User_table WHERE username = :username")
    suspend fun getEntity(username: String): QuizUserEntity

}
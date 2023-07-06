package com.example.corecommon.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.corecommon.data.local.entity.QuizUserEntity

@Dao
interface QuizUserDao {
    @Query("SELECT EXISTS(SELECT * FROM User_table WHERE username = :username)")
    suspend fun isUsernameRegistered(username: String): Boolean

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userEntity: QuizUserEntity)

    @Query("SELECT * FROM User_table WHERE isLoggedIn = true")
    suspend fun getUsernameIfLoggedIn(): QuizUserEntity?

    @Query("UPDATE User_table SET isLoggedIn =:activeStatus WHERE username =:username")
    suspend fun updateUserActiveStatus(username: String, activeStatus: Boolean)

    @Query("SELECT * FROM User_table WHERE username=:username")
    suspend fun getCurrentUser(username: String): QuizUserEntity
}
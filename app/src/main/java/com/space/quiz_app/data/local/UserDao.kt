package com.space.quiz_app.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM User_table")
    fun getAllUserNames(): Flow<List<UserEntity>>

    @Insert
    suspend fun insertUserName(userName: UserEntity)
}
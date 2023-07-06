package com.example.corecommon.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.corecommon.data.local.entity.QuizUserSubjectEntity

@Dao
interface QuizUserSubjectsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserSubject(userSubject: QuizUserSubjectEntity)

    @Query("SELECT * FROM user_subject WHERE username=:username")
    suspend fun getUserSubjects(username: String): List<QuizUserSubjectEntity>

    @Update
    suspend fun updateUserSubject(userSubject: QuizUserSubjectEntity)

    @Query("SELECT * FROM user_subject WHERE username=:username and quizTitle=:quizTitle")
    suspend fun getUserSubjectByTitle(username: String, quizTitle: String): QuizUserSubjectEntity?
}
package com.example.corecommon.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.corecommon.data.local.entity.QuizSubjectEntity

@Dao
interface QuizSubjectsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubjects(subject: List<QuizSubjectEntity>)

    @Query("SELECT * FROM subjects")
    suspend fun getAllSubject(): List<QuizSubjectEntity>
}
package com.space.quiz_app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.space.quiz_app.data.local.entity.QuizQuestionEntity

@Dao
interface QuizQuestionsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestion(questions: List<QuizQuestionEntity>)

    @Query("SELECT * FROM question WHERE subjectTitle = :subjectTitle")
    suspend fun getQuestions(subjectTitle: String): List<QuizQuestionEntity>

}
package com.space.quiz_app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subjects")
data class QuizSubjectEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val quizTitle: String = "",
    val quizDescription: String = "",
    val quizIcon: String = "",
    val questionsCount: Int = 0,
    val isCompleted: Boolean = false
)

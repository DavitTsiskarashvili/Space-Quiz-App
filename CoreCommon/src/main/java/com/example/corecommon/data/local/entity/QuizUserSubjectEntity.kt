package com.example.corecommon.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_subject")
data class QuizUserSubjectEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val username: String,
    val quizIcon: String,
    val quizTitle: String,
    val quizDescription: String,
    val score: Int,
    val questionsCount: Int = 0
)
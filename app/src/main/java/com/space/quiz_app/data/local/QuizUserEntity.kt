package com.space.quiz_app.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User_table")
data class QuizUserEntity(
    @PrimaryKey
    val username: String,
    val gpa: Float,
    val isLoggedIn: Boolean = false
)
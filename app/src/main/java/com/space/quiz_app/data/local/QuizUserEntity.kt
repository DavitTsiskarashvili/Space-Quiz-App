package com.space.quiz_app.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User_table")
data class QuizUserEntity(
    @PrimaryKey(autoGenerate = true)
    val userId: Int?,
    val userName: String
)
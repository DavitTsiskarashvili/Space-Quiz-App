package com.example.corecommon.model.user

data class QuizUserUIModel(
    val username: String,
    val gpa: Float = 0f,
    val isLoggedIn: Boolean = false
)

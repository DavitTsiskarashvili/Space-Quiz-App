package com.space.quiz_app.presentation.model.user

data class QuizUserUIModel(
    val username: String,
    val gpa: Float = 0f,
    val isLoggedIn: Boolean = false
)

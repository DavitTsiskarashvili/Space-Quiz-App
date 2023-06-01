package com.space.quiz_app.domain.model

data class QuizUserDomainModel(
    val username: String,
    val gpa: Float,
    val isLoggedIn: Boolean = false
)

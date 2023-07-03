package com.space.quiz_app.domain.model.user

data class QuizUserDomainModel(
    val username: String,
    val gpa: Float,
    val isLoggedIn: Boolean = false
)

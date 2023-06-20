package com.domain.model.user

data class QuizUserDomainModel(
    val username: String,
    val gpa: Float,
    val isLoggedIn: Boolean = false
)

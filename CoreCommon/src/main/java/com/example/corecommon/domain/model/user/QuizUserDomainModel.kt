package com.example.corecommon.domain.model.user

data class QuizUserDomainModel(
    val username: String,
    val gpa: Float,
    val isLoggedIn: Boolean = false
)

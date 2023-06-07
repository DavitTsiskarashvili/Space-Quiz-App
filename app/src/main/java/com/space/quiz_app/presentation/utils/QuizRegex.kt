package com.space.quiz_app.presentation.utils

object QuizRegex {
    val usernamePattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$".toRegex()
}
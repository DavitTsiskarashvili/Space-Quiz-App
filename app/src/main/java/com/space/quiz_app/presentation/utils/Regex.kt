package com.space.quiz_app.presentation.utils

object Regex {
    val pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$".toRegex()
}
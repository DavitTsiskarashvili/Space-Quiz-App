package com.space.quiz_app.presentation.utils


/**
Regular expression pattern for validating usernames.
The pattern requires the username to meet the following criteria:
At least one lowercase letter
At least one uppercase letter
At least one digit
Minimum length of 8 characters
 */

object QuizRegex {
    val usernamePattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$".toRegex()
}
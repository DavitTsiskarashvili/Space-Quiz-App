package com.space.quiz_app.presentation.utils

import androidx.annotation.StringRes
import com.space.quiz_app.R

enum class QuizUsernameValidation(@StringRes val errorText: Int) {
    USERNAME_INVALID_LENGTH_LONG(R.string.username_invalid_length_long),
    USERNAME_INVALID_LENGTH_SHORT(R.string.username_invalid_length_short),
    USERNAME_INVALID_CHARACTERS(R.string.username_invalid_characters),
    LOGIN_SUCCESS(R.string.login_success);

    companion object {
        const val MINIMUM = 8
        const val MAXIMUM = 20

        fun validate(input: String): QuizUsernameValidation {
            return when {
                input.length < MINIMUM -> USERNAME_INVALID_LENGTH_SHORT
                input.length > MAXIMUM -> USERNAME_INVALID_LENGTH_LONG
                !input.contains(QuizRegex.usernamePattern) -> USERNAME_INVALID_CHARACTERS
                else -> LOGIN_SUCCESS
            }
        }
    }
}


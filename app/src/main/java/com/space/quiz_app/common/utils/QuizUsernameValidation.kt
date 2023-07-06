package com.space.quiz_app.common.utils

import androidx.annotation.StringRes
import com.space.quiz_app.R

//This way of validation has to be changed
enum class QuizUsernameValidation(@StringRes val errorText: Int)  {
    USERNAME_INVALID_LENGTH_LONG(R.string.username_invalid_length_long),
    USERNAME_INVALID_LENGTH_SHORT(R.string.username_invalid_length_short),
    USERNAME_INVALID_CHARACTERS(R.string.username_invalid_characters),
    LOGIN_SUCCESS(R.string.login_success);

    companion object {
        fun validate(input: String): QuizUsernameValidation {
            return when {
                input.length <= 2 -> USERNAME_INVALID_LENGTH_SHORT
                input.length > 20 -> USERNAME_INVALID_LENGTH_LONG
                !input.contains(UsernameRegex.usernamePattern) -> USERNAME_INVALID_CHARACTERS
                else -> LOGIN_SUCCESS
            }
        }
    }

}


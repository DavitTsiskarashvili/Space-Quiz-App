package com.space.quiz_app.common.utils

import androidx.annotation.StringRes
import com.space.quiz_app.R

enum class QuizUsernameValidation(@StringRes val errorRes: Int)  {
    USERNAME_LONG(R.string.username_invalid_length_long),
    USERNAME_SHORT(R.string.username_invalid_length_short),
    INVALID_CHARACTERS(R.string.username_invalid_characters),
    USERNAME_VALID(R.string.login_success);

    companion object {
        fun validate(input: String): QuizUsernameValidation {
            return when {
                input.length <= 2 -> USERNAME_SHORT
                input.length > 20 -> USERNAME_LONG
                !input.contains(UsernameRegex.usernamePattern) -> INVALID_CHARACTERS
                else -> USERNAME_VALID
            }
        }
    }

}


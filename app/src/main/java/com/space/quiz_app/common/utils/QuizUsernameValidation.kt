package com.space.quiz_app.common.utils

import androidx.annotation.StringRes
import com.space.quiz_app.R

enum class QuizUsernameValidation(@StringRes val errorRes: Int) {
    USERNAME_LONG(R.string.username_invalid_length_long),
    USERNAME_SHORT(R.string.username_invalid_length_short),
    INVALID_CHARACTERS(R.string.username_invalid_characters),
    USERNAME_VALID(R.string.login_success)
}


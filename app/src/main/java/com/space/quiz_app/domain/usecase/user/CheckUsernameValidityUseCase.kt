package com.space.quiz_app.domain.usecase.user

import com.space.quiz_app.common.utils.QuizUsernameValidation
import com.space.quiz_app.common.utils.UsernameRegex
import com.space.quiz_app.domain.usecase.base.BaseUseCase

class CheckUsernameValidityUseCase: BaseUseCase<String, QuizUsernameValidation>() {

    override suspend fun invoke(params: String?): QuizUsernameValidation {
        return when {
            params!!.length <= 2 -> QuizUsernameValidation.USERNAME_SHORT
            params.length > 20 -> QuizUsernameValidation.USERNAME_LONG
            !params.contains(UsernameRegex.usernamePattern) -> QuizUsernameValidation.INVALID_CHARACTERS
            else -> QuizUsernameValidation.USERNAME_VALID
        }
    }
}
package com.space.quiz_app.domain.usecase.user

import com.example.corecommon.base.use_case.BaseUseCase
import com.example.corecommon.common.utils.QuizUsernameValidation

class CheckUsernameValidityUseCase: BaseUseCase<String, QuizUsernameValidation>() {

    override suspend fun invoke(params: String?): com.example.corecommon.common.utils.QuizUsernameValidation {
        return when {
            params!!.length <= 2 -> com.example.corecommon.common.utils.QuizUsernameValidation.USERNAME_SHORT
            params.length > 20 -> com.example.corecommon.common.utils.QuizUsernameValidation.USERNAME_LONG
            !params.contains(com.example.corecommon.common.utils.UsernameRegex.usernamePattern) -> com.example.corecommon.common.utils.QuizUsernameValidation.INVALID_CHARACTERS
            else -> com.example.corecommon.common.utils.QuizUsernameValidation.USERNAME_VALID
        }
    }
}
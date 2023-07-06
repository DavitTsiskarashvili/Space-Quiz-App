package com.example.main_impl.domain.usecase.user

import com.example.corecommon.base.use_case.BaseUseCase
import com.example.corecommon.common.utils.QuizUsernameValidation
import com.example.corecommon.common.utils.UsernameRegex

class CheckUsernameValidityUseCase : BaseUseCase<String, QuizUsernameValidation>() {

    override suspend fun invoke(params: String?): QuizUsernameValidation {
        return when {
            params!!.length <= 2 -> QuizUsernameValidation.USERNAME_SHORT
            params.length > 20 -> QuizUsernameValidation.USERNAME_LONG
            !params.contains(UsernameRegex.usernamePattern) -> QuizUsernameValidation.INVALID_CHARACTERS
            else -> QuizUsernameValidation.USERNAME_VALID
        }
    }
}
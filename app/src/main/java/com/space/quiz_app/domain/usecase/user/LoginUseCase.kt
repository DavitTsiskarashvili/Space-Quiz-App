package com.space.quiz_app.domain.usecase.user

import com.example.corecommon.base.use_case.BaseUseCase
import com.example.corecommon.common.utils.QuizUsernameValidation
import com.example.corecommon.domain.model.user.QuizUserDomainModel
import com.example.corecommon.domain.repository.QuizUserRepository
import com.example.main_impl.domain.usecase.user.CheckUsernameValidityUseCase

class LoginUseCase(
    private val userRepository: QuizUserRepository,
    private val usernameValidity: CheckUsernameValidityUseCase
) : BaseUseCase<QuizUserDomainModel, QuizUsernameValidation>() {

    override suspend fun invoke(params: QuizUserDomainModel?): com.example.corecommon.common.utils.QuizUsernameValidation {
        val validUsername: com.example.corecommon.common.utils.QuizUsernameValidation =
            usernameValidity(params!!.username)
        if (validUsername == com.example.corecommon.common.utils.QuizUsernameValidation.USERNAME_VALID) {
            loginUser(params.username)
        }
        return validUsername
    }

    private suspend fun loginUser(username: String) {
        when (userRepository.getUsernameIfLoggedIn()) {
            null -> {
                userRepository.loginUser(username)
            }
        }
    }

}
package com.space.quiz_app.domain.usecase.user

import com.space.quiz_app.common.utils.QuizUsernameValidation
import com.space.quiz_app.domain.model.user.QuizUserDomainModel
import com.space.quiz_app.domain.repository.QuizUserRepository
import com.space.quiz_app.domain.usecase.base.BaseUseCase

class LoginUseCase(
    private val userRepository: QuizUserRepository,
    private val usernameValidity: CheckUsernameValidityUseCase
) : BaseUseCase<QuizUserDomainModel, QuizUsernameValidation>() {

    override suspend fun invoke(params: QuizUserDomainModel?): QuizUsernameValidation {
        val validUsername: QuizUsernameValidation = usernameValidity(params!!.username)
        if (validUsername == QuizUsernameValidation.USERNAME_VALID) {
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
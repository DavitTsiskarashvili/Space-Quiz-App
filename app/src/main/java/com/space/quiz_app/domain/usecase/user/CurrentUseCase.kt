package com.space.quiz_app.domain.usecase.user

import com.space.quiz_app.domain.model.user.QuizUserDomainModel
import com.space.quiz_app.domain.repository.QuizUserRepository
import com.space.quiz_app.domain.usecase.base.BaseUseCase

class CurrentUseCase(
    private val userRepository: QuizUserRepository,
) : BaseUseCase<Unit, QuizUserDomainModel?>() {

    override suspend fun invoke(params: Unit?): QuizUserDomainModel? {
        return userRepository.getUsernameIfLoggedIn()
    }

}
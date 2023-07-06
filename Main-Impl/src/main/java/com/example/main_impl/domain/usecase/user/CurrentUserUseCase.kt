package com.example.main_impl.domain.usecase.user

import com.example.corecommon.base.use_case.BaseUseCase
import com.example.corecommon.domain.model.user.QuizUserDomainModel
import com.example.corecommon.domain.repository.QuizUserRepository

class CurrentUserUseCase(
    private val userRepository: QuizUserRepository,
) : BaseUseCase<Unit, QuizUserDomainModel?>() {

    override suspend fun invoke(params: Unit?): QuizUserDomainModel? {
        return userRepository.getUsernameIfLoggedIn()
    }

}
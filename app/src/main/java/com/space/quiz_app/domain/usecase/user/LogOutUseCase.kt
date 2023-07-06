package com.space.quiz_app.domain.usecase.user

import com.example.corecommon.base.use_case.BaseUseCase
import com.example.corecommon.domain.repository.QuizUserRepository
import com.example.corecommon.model.mapper.user.QuizUserDomainToUIMapper
import com.example.corecommon.model.mapper.user.QuizUserUIToDomainMapper
import com.example.corecommon.model.user.QuizUserUIModel
import com.example.quiz_impl.domain.usecase.user.CurrentUserUseCase

class LogOutUseCase(
    private val userRepository: QuizUserRepository,
    private val userDomainMapper: QuizUserDomainToUIMapper,
    private val userUIMapper: QuizUserUIToDomainMapper,
    private val currentUser: CurrentUserUseCase
) : BaseUseCase<Unit, Unit>() {

    override suspend fun invoke(params: Unit?) {
        replaceUsername(userDomainMapper(currentUser()!!.copy(isLoggedIn = false)))
    }

    private suspend fun replaceUsername(username: QuizUserUIModel) {
        userRepository.insertUsername(userUIMapper(username))
    }

}
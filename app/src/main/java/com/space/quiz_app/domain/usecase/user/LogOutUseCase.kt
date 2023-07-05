package com.space.quiz_app.domain.usecase.user

import com.space.quiz_app.domain.repository.QuizUserRepository
import com.space.quiz_app.domain.usecase.base.BaseUseCase
import com.space.quiz_app.presentation.feature.model.mapper.user.QuizUserDomainToUIMapper
import com.space.quiz_app.presentation.feature.model.mapper.user.QuizUserUIToDomainMapper
import com.space.quiz_app.presentation.feature.model.user.QuizUserUIModel

class LogOutUseCase(
    private val userRepository: QuizUserRepository,
    private val userDomainMapper: QuizUserDomainToUIMapper,
    private val userUIMapper: QuizUserUIToDomainMapper,
    private val currentUser: CurrentUseCase
) : BaseUseCase<Unit, Unit>() {

    override suspend fun invoke(params: Unit?) {
        replaceUsername(userDomainMapper(currentUser()!!.copy(isLoggedIn = false)))
    }

    private suspend fun replaceUsername(username: QuizUserUIModel) {
        userRepository.insertUsername(userUIMapper(username))
    }

}
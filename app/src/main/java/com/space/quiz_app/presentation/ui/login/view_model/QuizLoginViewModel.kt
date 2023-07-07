package com.space.quiz_app.presentation.ui.login.view_model

import com.space.quiz_app.common.extensions.viewModelScope
import com.space.quiz_app.common.utils.QuizUsernameValidation
import com.space.quiz_app.domain.model.user.QuizUserDomainModel
import com.space.quiz_app.domain.repository.QuizUserRepository
import com.space.quiz_app.domain.usecase.user.LoginUseCase
import com.space.quiz_app.presentation.feature.base.view_model.QuizBaseViewModel
import com.space.quiz_app.presentation.ui.login.ui.QuizLoginFragmentDirections

class QuizLoginViewModel(
    private val quizUserRepository: QuizUserRepository,
    private val loginUseCase: LoginUseCase
) : QuizBaseViewModel() {

    fun checkUserLoggedInStatus() {
        viewModelScope {
           quizUserRepository.getUsernameIfLoggedIn()?.let {
               navigateToHome()
           }
        }
    }

    fun login(username: String) {
        viewModelScope {
            val validUsername = loginUseCase(QuizUserDomainModel(username, 0f, true))
            when (validUsername) {
                QuizUsernameValidation.USERNAME_VALID -> {
                    navigateToHome()
                }
                else -> showError(validUsername.errorRes)
            }
        }
    }

    private fun navigateToHome() {
        navigate(QuizLoginFragmentDirections.actionGlobalHomeFragment())
    }

}
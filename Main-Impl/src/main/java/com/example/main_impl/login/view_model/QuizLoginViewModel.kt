package com.example.main_impl.login.view_model

import com.example.corecommon.common.extensions.viewModelScope
import com.example.corecommon.domain.model.user.QuizUserDomainModel
import com.example.corecommon.domain.repository.QuizUserRepository
import com.example.main_impl.domain.usecase.user.LoginUseCase
import com.space.quiz_app.presentation.ui.login.ui.QuizLoginFragmentDirections

class QuizLoginViewModel(
    private val quizUserRepository: QuizUserRepository,
    private val loginUseCase: LoginUseCase
) : com.example.corecommon.base.view_model.QuizBaseViewModel() {

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
                com.example.corecommon.common.utils.QuizUsernameValidation.USERNAME_VALID -> {
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
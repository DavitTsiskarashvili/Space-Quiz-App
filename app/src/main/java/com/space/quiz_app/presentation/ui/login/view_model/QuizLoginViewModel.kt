package com.space.quiz_app.presentation.ui.login.view_model

import com.space.quiz_app.common.extensions.viewModelScope
import com.space.quiz_app.common.utils.QuizUsernameValidation
import com.space.quiz_app.domain.repository.QuizUserRepository
import com.space.quiz_app.presentation.feature.base.view_model.QuizBaseViewModel
import com.space.quiz_app.presentation.ui.login.ui.QuizLoginFragmentDirections

class QuizLoginViewModel(
    private val quizUserRepository: QuizUserRepository,
) : QuizBaseViewModel() {

    fun checkUserLoggedInStatus() {
        viewModelScope {
            val getUsername = quizUserRepository.getUsernameIfLoggedIn()?.isLoggedIn
            getUsername?.let {
                if (it) {
                    navigateToHome()
                }
            }
        }
    }

    fun checkUsernameValidity(username: String) {
        viewModelScope {
            val validity = QuizUsernameValidation.validate(username)
            when (validity) {
                QuizUsernameValidation.USERNAME_VALID -> {
                    loginUser(username)
                    navigateToHome()
                }
                else -> showError(validity.errorRes)
            }
        }
    }

    private suspend fun loginUser(username: String) {
        when (quizUserRepository.getUsernameIfLoggedIn()) {
            null -> {
                quizUserRepository.loginUser(username)
            }
        }
    }

    private fun navigateToHome() {
        navigate(QuizLoginFragmentDirections.actionGlobalHomeFragment())
    }

}
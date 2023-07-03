package com.space.quiz_app.presentation.ui.login.view_model

import com.space.quiz_app.common.extensions.viewModelScope
import com.space.quiz_app.common.utils.QuizUsernameValidation
import com.space.quiz_app.domain.repository.QuizUserRepository
import com.space.quiz_app.presentation.feature.base.view_model.QuizBaseViewModel
import com.space.quiz_app.presentation.ui.login.ui.QuizLoginFragmentDirections
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class QuizLoginViewModel(
    private val quizUserRepository: QuizUserRepository,
) : QuizBaseViewModel() {

    private val _validationError = MutableStateFlow<QuizUsernameValidation?>(null)
    val validationError = _validationError.asStateFlow()

    fun checkUserLogState() {
        viewModelScope {
            val getUsername = quizUserRepository.getUsernameIfLoggedIn()?.isLoggedIn
            getUsername?.let {
                if (it) {
                    navigate()
                }
            }
        }
    }

    fun checkUsernameValidity(username: String) {
        viewModelScope {
            val validity = QuizUsernameValidation.validate(username)
            if (validity == QuizUsernameValidation.LOGIN_SUCCESS) {
                loginUser(username)
                navigate()
            } else {
                _validationError.emit(validity)
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

    private fun navigate() {
        navigate(QuizLoginFragmentDirections.actionGlobalHomeFragment())
    }

}
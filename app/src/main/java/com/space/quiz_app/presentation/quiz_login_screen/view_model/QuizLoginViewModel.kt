package com.space.quiz_app.presentation.quiz_login_screen.view_model

import com.space.quiz_app.common.extensions.viewModelScope
import com.space.quiz_app.domain.repository.QuizUserRepository
import com.space.quiz_app.presentation.base.view_model.QuizBaseViewModel
import com.space.quiz_app.presentation.mapper.user.QuizUserDomainToUIMapper
import com.space.quiz_app.presentation.mapper.user.QuizUserUIToDomainMapper
import com.space.quiz_app.presentation.model.user.QuizUserUIModel
import com.space.quiz_app.presentation.quiz_login_screen.ui.QuizLoginFragmentDirections
import com.space.quiz_app.presentation.utils.QuizUsernameValidation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class QuizLoginViewModel(
    private val quizUserRepository: QuizUserRepository,
    private val quizUserUIToDomainMapper: QuizUserUIToDomainMapper,
    private val quizUserDomainToUIMapper: QuizUserDomainToUIMapper
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
        val getUsername = quizUserRepository.getUsernameIfLoggedIn()
        when {
            getUsername == null -> {
                insertUsername(QuizUserUIModel(username, isLoggedIn = true))
            }
            !getUsername.isLoggedIn -> {
                insertUsername(quizUserDomainToUIMapper(getUsername.copy(isLoggedIn = true)))
            }
        }
    }

    private suspend fun insertUsername(username: QuizUserUIModel) {
        quizUserRepository.insertUsername(quizUserUIToDomainMapper((username)))
    }

    private fun navigate() {
        navigate(QuizLoginFragmentDirections.actionGlobalHomeFragment())
    }

}
package com.presentation.view_model

import com.base.view_model.QuizBaseViewModel
import com.domain.repository.QuizUserRepository
import com.extensions.viewModelScope
import com.presentation.mapper.QuizUserDomainToUIMapper
import com.presentation.mapper.QuizUserUIToDomainMapper
import com.presentation.model.QuizUserUIModel
import com.presentation.utils.QuizUsernameValidation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.navigation.NavigationCommand.ToDirection


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
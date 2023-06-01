package com.space.quiz_app.presentation.quiz_login_screen.view_model

import com.space.quiz_app.common.extensions.viewModelScope
import com.space.quiz_app.domain.repository.QuizUserRepository
import com.space.quiz_app.presentation.base.QuizBaseViewModel
import com.space.quiz_app.presentation.mapper.QuizUserDomainToUIMapper
import com.space.quiz_app.presentation.mapper.QuizUserUIToDomainMapper
import com.space.quiz_app.presentation.model.QuizUserUIModel
import com.space.quiz_app.presentation.quiz_login_screen.ui.QuizLoginFragmentDirections
import com.space.quiz_app.presentation.utils.QuizUsernameValidation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect

class QuizLoginViewModel(
    private val quizUserRepository: QuizUserRepository,
    private val quizUserUIToDomainMapper: QuizUserUIToDomainMapper,
    private val quizUserDomainToUIMapper: QuizUserDomainToUIMapper
) : QuizBaseViewModel() {

    private val _validationError = MutableStateFlow<QuizUsernameValidation?>(null)
    val validationError = _validationError.asStateFlow()

    fun checkUsernameValidity(username: String) {
        viewModelScope {
            val validity = QuizUsernameValidation.validate(username)
            if (validity == QuizUsernameValidation.LOGIN_SUCCESS) {
                insertUsername(username)
                navigate()
            } else {
                _validationError.emit(validity)
            }
        }
    }

    fun checkUserLogState(username: String){
        viewModelScope {
            quizUserRepository.getEntityIfLoggedIn().collect{
                if (it == null){
                    insertUsername(QuizUserUIModel(username))
                } else {
                    insertUsername(quizUserDomainToUIMapper(it.copy(isLoggedIn = true)))
                }
            }
        }
    }

    private suspend fun insertUsername(username: String) {
        quizUserRepository.insertUsername(quizUserUIToDomainMapper(QuizUserUIModel(username)))
    }

    private fun navigate() {
        navigate(QuizLoginFragmentDirections.actionLoginFragmentToHomeFragment())
    }

}
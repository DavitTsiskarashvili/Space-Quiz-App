package com.space.quiz_app.presentation.quiz_login_screen.view_model

import androidx.lifecycle.viewModelScope
import com.space.quiz_app.domain.model.QuizUserDomainModel
import com.space.quiz_app.domain.repository.QuizUserRepository
import com.space.quiz_app.presentation.base.QuizBaseViewModel
import com.space.quiz_app.presentation.mapper.QuizUserDomainToUIMapper
import com.space.quiz_app.presentation.mapper.QuizUserUIToDomainMapper
import com.space.quiz_app.presentation.model.QuizUserUIModel
import com.space.quiz_app.presentation.quiz_login_screen.ui.QuizLoginFragmentDirections
import com.space.quiz_app.presentation.utils.Validation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class QuizLoginViewModel(
    private val quizUserRepository: QuizUserRepository,
    private val quizUserUIToDomainMapper: QuizUserUIToDomainMapper,
    private val quizUserDomainToUIMapper: QuizUserDomainToUIMapper
) : QuizBaseViewModel() {

    private val _validationError = MutableStateFlow<Validation?>(null)
    val validationError = _validationError.asStateFlow()

    private val _isLoggedIn = MutableStateFlow<Boolean>(false)
    val isLoggedIn = _isLoggedIn.asStateFlow()

    fun isValidUsername(username: String) {
        viewModelScope.launch {
            val error = Validation.validate(username)
            if (error == Validation.LOGIN_SUCCESS) {
                getUserIfLoggedIn(username)
            } else {
                _validationError.emit(error)
            }
        }
    }

    private fun getUserIfLoggedIn(username: String){
        viewModelScope.launch {
            quizUserRepository.getEntityIfLoggedIn().collect{
                if (it == null){
                    insertUsername(QuizUserUIModel(username))
                    navigate()
                } else {
                    insertUsername(quizUserDomainToUIMapper(it.copy(isLoggedIn = true)))
                    navigate()
                }
            }
        }
    }

    private suspend fun insertUsername(username: QuizUserUIModel) {
        quizUserRepository.insertUsername(quizUserUIToDomainMapper((username)))
    }

    private fun navigate() {
        navigate(QuizLoginFragmentDirections.actionLoginFragmentToHomeFragment())
    }

}
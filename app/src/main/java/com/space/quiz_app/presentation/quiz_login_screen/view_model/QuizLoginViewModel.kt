package com.space.quiz_app.presentation.quiz_login_screen.view_model

import androidx.lifecycle.viewModelScope
import com.space.quiz_app.domain.repository.QuizUserRepository
import com.space.quiz_app.presentation.base.QuizBaseViewModel
import com.space.quiz_app.presentation.mapper.QuizUserUIToDomainMapper
import com.space.quiz_app.presentation.model.QuizUserUIModel
import com.space.quiz_app.presentation.quiz_login_screen.ui.QuizLoginFragmentDirections
import com.space.quiz_app.presentation.utils.Regex.pattern
import com.space.quiz_app.presentation.utils.Validation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class QuizLoginViewModel(
    private val quizUserRepository: QuizUserRepository,
    private val quizUserUIToDomainMapper: QuizUserUIToDomainMapper
) : QuizBaseViewModel() {

    private val _validationError = MutableStateFlow<Validation?>(null)
    val validationError = _validationError.asStateFlow()

    private suspend fun insertUsername(username: String) {
        quizUserRepository.insertUsername(quizUserUIToDomainMapper(QuizUserUIModel(username)))
    }

    private fun navigate() {
        navigate(QuizLoginFragmentDirections.actionLoginFragmentToHomeFragment())
    }

    fun isValidUsername(username: String) {
        viewModelScope.launch {
            val error = Validation.validate(username)
            if (error == Validation.LOGIN_SUCCESS) {
                insertUsername(username)
                navigate()
            } else {
                _validationError.emit(error)
            }
        }
    }

}
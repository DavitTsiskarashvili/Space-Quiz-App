package com.space.quiz_app.presentation.quiz_login_screen.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.space.quiz_app.domain.model.QuizUserDomainModel
import com.space.quiz_app.domain.repository.QuizUserRepository
import com.space.quiz_app.presentation.base.BaseViewModel
import com.space.quiz_app.presentation.quiz_login_screen.mapper.QuizUserDomainToUIMapper
import com.space.quiz_app.presentation.quiz_login_screen.mapper.QuizUserUIToDomainMapper
import com.space.quiz_app.presentation.quiz_login_screen.model.QuizUserUIModel
import com.space.quiz_app.presentation.quiz_login_screen.ui.QuizLoginFragment
import com.space.quiz_app.presentation.quiz_login_screen.ui.QuizLoginFragmentDirections
import com.space.quiz_app.presentation.utils.Regex.pattern
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class QuizLoginViewModel(
    private val quizUserRepository: QuizUserRepository,
    private val quizUserUIToDomainMapper: QuizUserUIToDomainMapper
) : BaseViewModel() {

    private val _validState = MutableSharedFlow<Boolean>()
    val validState = _validState.asSharedFlow()

    val navigate = MutableSharedFlow<Boolean>()

    private suspend fun insertUsername(username: String) {
        quizUserRepository.insertUsername(quizUserUIToDomainMapper(QuizUserUIModel(username)))
    }

    fun navigate() {
        navigate(QuizLoginFragmentDirections.actionLoginFragmentToHomeFragment())
    }

    fun isValidUsername(username: String) {
        if (pattern.matches(username)) {
            viewModelScope.launch {
                insertUsername(username)
                navigate.emit(true)
            }
        }
    }

}
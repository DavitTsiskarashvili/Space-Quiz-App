package com.space.quiz_app.presentation.quiz_home_screen.view_model

import androidx.lifecycle.viewModelScope
import com.space.quiz_app.domain.repository.QuizUserRepository
import com.space.quiz_app.presentation.base.view_model.QuizBaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class QuizHomeViewModel(
    private val quizUserRepository: QuizUserRepository,
) : QuizBaseViewModel() {

    private val _usernameState = MutableStateFlow("")
    val usernameState = _usernameState.asStateFlow()

    fun getUsername() {
        viewModelScope.launch {
            quizUserRepository.getEntityIfLoggedIn().collect {
                it?.let { _usernameState.emit(it.username) }
            }
        }
    }

}
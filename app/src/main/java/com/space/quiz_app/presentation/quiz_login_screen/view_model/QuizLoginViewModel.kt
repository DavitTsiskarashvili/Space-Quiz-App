package com.space.quiz_app.presentation.quiz_login_screen.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.space.quiz_app.domain.model.QuizUserDomainModel
import com.space.quiz_app.domain.repository.QuizUserRepository
import com.space.quiz_app.presentation.quiz_login_screen.mapper.QuizUserDomainToUIMapper
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class QuizLoginViewModel(
    private val quizUserRepository: QuizUserRepository,
) : ViewModel() {

    private suspend fun insertUsername(username: String) {
        quizUserRepository.insertUsername(
            username = provideUserModel(
                username
            )
        )
    }

    private fun provideUserModel(
        usernameInput: String,
    ) =
        QuizUserDomainModel(
            username = usernameInput,
        )

    fun checkLoginStatus(username: String) {
        viewModelScope.launch {
            if (!quizUserRepository.isUsernameRegistered(username)) {
                insertUsername(username)
            }
        }
    }

}
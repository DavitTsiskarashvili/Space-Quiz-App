package com.space.quiz_app.presentation.quiz_login_screen.view_model

import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import com.space.quiz_app.domain.repository.QuizUserRepository
import com.space.quiz_app.presentation.base.QuizBaseViewModel
import com.space.quiz_app.presentation.quiz_login_screen.mapper.QuizUserUIToDomainMapper
import com.space.quiz_app.presentation.quiz_login_screen.model.QuizUserUIModel
import com.space.quiz_app.presentation.quiz_login_screen.ui.QuizLoginFragmentDirections
import com.space.quiz_app.presentation.utils.Regex.pattern
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class QuizLoginViewModel(
    private val quizUserRepository: QuizUserRepository,
    private val quizUserUIToDomainMapper: QuizUserUIToDomainMapper
) : QuizBaseViewModel() {

    private suspend fun insertUsername(username: String) {
        quizUserRepository.insertUsername(quizUserUIToDomainMapper(QuizUserUIModel(username)))
    }

    private fun navigate() {
        navigate(QuizLoginFragmentDirections.actionLoginFragmentToHomeFragment())
    }

    fun isValidUsername(username: String) {
        if (pattern.matches(username)) {
            viewModelScope.launch {
                insertUsername(username)
                navigate()
            }
        }
    }

}
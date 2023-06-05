package com.space.quiz_app.presentation.quiz_home_screen.view_model

import androidx.lifecycle.viewModelScope
import com.space.quiz_app.common.extensions.viewModelScope
import com.space.quiz_app.data.remote.service.result_handler.resource.Resource
import com.space.quiz_app.domain.model.questions.QuizQuestionsDomainModel
import com.space.quiz_app.domain.repository.QuizSubjectsRepository
import com.space.quiz_app.domain.repository.QuizUserRepository
import com.space.quiz_app.presentation.base.view_model.QuizBaseViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class QuizHomeViewModel(
    private val quizUserRepository: QuizUserRepository,
    private val quizSubjectsRepository: QuizSubjectsRepository
) : QuizBaseViewModel() {

    private val _usernameState = MutableStateFlow("")
    val usernameState = _usernameState.asStateFlow()

    private val _subjectsState = MutableStateFlow< Resource<QuizQuestionsDomainModel>>(Resource.Loader(false))
    val subjectsState = _subjectsState.asStateFlow()

    fun getUsername() {
        viewModelScope {
            quizUserRepository.getEntityIfLoggedIn().collect {
                it?.let { _usernameState.emit(it.username) }
            }
        }
    }

    fun getSubjects(){
        viewModelScope {
            quizSubjectsRepository
        }
    }

}
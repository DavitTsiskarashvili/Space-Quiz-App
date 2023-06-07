package com.space.quiz_app.presentation.quiz_home_screen.view_model

import com.space.quiz_app.common.extensions.viewModelScope
import com.space.quiz_app.data.remote.service.result_handler.resource.Resource
import com.space.quiz_app.domain.repository.QuizSubjectsRepository
import com.space.quiz_app.domain.repository.QuizUserRepository
import com.space.quiz_app.presentation.base.view_model.QuizBaseViewModel
import com.space.quiz_app.presentation.mapper.question.QuizQuestionDomainMapper
import com.space.quiz_app.presentation.model.questions.QuizQuestionsUIModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class QuizHomeViewModel(
    private val quizUserRepository: QuizUserRepository,
    private val quizSubjectsRepository: QuizSubjectsRepository,
    private val quizQuestionsUIMapper: QuizQuestionDomainMapper
) : QuizBaseViewModel() {

    private val _usernameState = MutableStateFlow("")
    val usernameState = _usernameState.asStateFlow()

    private val _subjectsState =
        MutableStateFlow<List<QuizQuestionsUIModel>?>(null)
    val subjectsState = _subjectsState.asStateFlow()

    private val _errorState =
        MutableStateFlow<Throwable?>(null)
    val errorState = _errorState.asStateFlow()

    private val _loadingState =
        MutableStateFlow<Boolean>(true)
    val loadingState = _loadingState.asStateFlow()

    fun getUsername() {
        viewModelScope {
            quizUserRepository.getEntityIfLoggedIn().collect {
                it?.let { _usernameState.emit(it.username) }
            }
        }
    }

    fun getSubjects() {
        viewModelScope {
            val result = quizSubjectsRepository.getSubjects()
            when (result) {
                is Resource.Success -> {
                    _subjectsState.emit(result.data.map {
                        quizQuestionsUIMapper(it)
                    })
                }
                is Resource.Error -> {
                    _errorState.emit(result.errorMessage)
                }
                else -> {}
            }
            _loadingState.emit(result.loader)
        }
    }

}
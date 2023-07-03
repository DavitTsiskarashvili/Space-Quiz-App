package com.space.quiz_app.presentation.quiz_home_screen.view_model

import com.space.quiz_app.common.extensions.viewModelScope
import com.space.quiz_app.data.remote.service.result_handler.resource.Resource
import com.space.quiz_app.domain.repository.QuizSubjectsRepository
import com.space.quiz_app.domain.repository.QuizUserRepository
import com.space.quiz_app.presentation.base.view_model.QuizBaseViewModel
import com.space.quiz_app.presentation.mapper.question.QuizQuestionDomainMapper
import com.space.quiz_app.presentation.mapper.user.QuizUserDomainToUIMapper
import com.space.quiz_app.presentation.mapper.user.QuizUserUIToDomainMapper
import com.space.quiz_app.presentation.model.questions.QuizQuestionsUIModel
import com.space.quiz_app.presentation.model.user.QuizUserUIModel
import com.space.quiz_app.presentation.quiz_home_screen.ui.QuizHomeFragmentDirections
import com.space.quiz_app.presentation.utils.QuizLiveDataDelegate
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class QuizHomeViewModel(
    private val quizUserRepository: QuizUserRepository,
    private val quizSubjectsRepository: QuizSubjectsRepository,
    private val quizQuestionsUIMapper: QuizQuestionDomainMapper,
    private val quizUserUIToDomainMapper: QuizUserUIToDomainMapper,
    private val quizUserDomainToUIMapper: QuizUserDomainToUIMapper
) : QuizBaseViewModel() {

    val usernameState by QuizLiveDataDelegate("")
    val subjectsState by QuizLiveDataDelegate<List<QuizQuestionsUIModel>?>(null)
    val loadingState by QuizLiveDataDelegate(true)
    val errorState by QuizLiveDataDelegate<Throwable?>(null)

    fun getUsername() {
        viewModelScope {
            val username = quizUserRepository.getUsernameIfLoggedIn()
            username?.let { usernameState.addValue(it.username) }
        }
    }

    fun getSubjects() {
        viewModelScope {
            val result = quizSubjectsRepository.getSubjects()
            when (result) {
                is Resource.Success -> {
                    subjectsState.addValue(result.data.map {
                        quizQuestionsUIMapper(it)
                    })
                }
                is Resource.Error -> {
                    errorState.addValue(result.errorMessage)
                }
                else -> {}
            }
            loadingState.addValue(result.loader)
        }
    }

    fun logOutUser(navigate: () -> Unit) {
        viewModelScope {
            val replaceUsername = quizUserRepository.getUsernameIfLoggedIn()
            replaceUsername(quizUserDomainToUIMapper(replaceUsername!!.copy(isLoggedIn = false)))
            navigate()
        }
    }

    private suspend fun replaceUsername(username: QuizUserUIModel) {
        quizUserRepository.insertUsername(quizUserUIToDomainMapper((username)))
    }

    fun navigateToHome() {
        navigate(QuizHomeFragmentDirections.actionGlobalLoginFragment())
    }

    fun navigateToGPA(){
        navigate(QuizHomeFragmentDirections.actionGlobalGpaFragment())
    }

    fun navigateToQuiz(){
        navigate(QuizHomeFragmentDirections.actionGlobalQuestionsFragment())
    }
}
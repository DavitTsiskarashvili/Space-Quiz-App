package com.space.quiz_app.presentation.ui.home.view_model

import com.space.quiz_app.common.extensions.viewModelScope
import com.space.quiz_app.common.utils.QuizLiveDataDelegate
import com.space.quiz_app.domain.repository.QuizSubjectsRepository
import com.space.quiz_app.domain.repository.QuizUserRepository
import com.space.quiz_app.presentation.feature.base.view_model.QuizBaseViewModel
import com.space.quiz_app.presentation.feature.model.mapper.subject.QuizSubjectDomainMapper
import com.space.quiz_app.presentation.feature.model.mapper.user.QuizUserDomainToUIMapper
import com.space.quiz_app.presentation.feature.model.mapper.user.QuizUserUIToDomainMapper
import com.space.quiz_app.presentation.feature.model.subject.QuizSubjectUIModel
import com.space.quiz_app.presentation.feature.model.user.QuizUserUIModel
import com.space.quiz_app.presentation.ui.home.ui.QuizHomeFragmentDirections

class QuizHomeViewModel(
    private val quizUserRepository: QuizUserRepository,
    private val quizSubjectsRepository: QuizSubjectsRepository,
    private val quizSubjectDomainMapper: QuizSubjectDomainMapper,
    private val quizUserUIToDomainMapper: QuizUserUIToDomainMapper,
    private val quizUserDomainToUIMapper: QuizUserDomainToUIMapper
) : QuizBaseViewModel() {

    val userState by QuizLiveDataDelegate<QuizUserUIModel?>(null)
    val subjectsState by QuizLiveDataDelegate<List<QuizSubjectUIModel>?>(null)
    val loadingState by QuizLiveDataDelegate(true)
    val errorState by QuizLiveDataDelegate<Throwable?>(null)
    private val selectedSubjectTitleState by QuizLiveDataDelegate<QuizSubjectUIModel?>(null)

    fun getUsername() {
        viewModelScope {
            val username = quizUserRepository.getUsernameIfLoggedIn()
            username?.let { userState.addValue(quizUserDomainToUIMapper(it)) }
        }
    }

    fun getSubjects() {
        viewModelScope {
            val result = quizSubjectsRepository.getSubjectsFromNetwork()
            subjectsState.addValue(result.map {
                quizSubjectDomainMapper(it)
            })
            loadingState.addValue(false)
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
        quizUserRepository.insertUsername(quizUserUIToDomainMapper(username))
    }

    fun onSubjectItemClick(subjectTitle: QuizSubjectUIModel) {
        selectedSubjectTitleState.addValue(subjectTitle)
    }

    fun navigateToHome() {
        navigate(QuizHomeFragmentDirections.actionGlobalLoginFragment())
    }

    fun navigateToGPA() {
        navigate(QuizHomeFragmentDirections.actionGlobalGpaFragment())
    }

    fun navigateToQuiz(subjectTitle: QuizSubjectUIModel) {
        navigate(QuizHomeFragmentDirections.actionGlobalQuestionsFragment(subjectTitle))
    }
}
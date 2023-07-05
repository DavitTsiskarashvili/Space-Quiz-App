package com.space.quiz_app.presentation.ui.details.view_model

import com.space.quiz_app.common.extensions.viewModelScope
import com.space.quiz_app.common.utils.QuizLiveDataDelegate
import com.space.quiz_app.domain.repository.QuizUserRepository
import com.space.quiz_app.domain.repository.QuizUserSubjectsRepository
import com.space.quiz_app.presentation.feature.base.view_model.QuizBaseViewModel
import com.space.quiz_app.presentation.feature.model.mapper.user.QuizUserDomainToUIMapper
import com.space.quiz_app.presentation.feature.model.mapper.user.QuizUserSubjectDomainToUIMapper
import com.space.quiz_app.presentation.feature.model.mapper.user.QuizUserUIToDomainMapper
import com.space.quiz_app.presentation.feature.model.user.QuizUserSubjectUIModel
import com.space.quiz_app.presentation.feature.model.user.QuizUserUIModel
import com.space.quiz_app.presentation.ui.details.ui.QuizDetailsFragmentDirections

class QuizDetailsViewModel(
    private val quizUserRepository: QuizUserRepository,
    private val userSubjectsRepository: QuizUserSubjectsRepository,
    private val quizUserUIToDomainMapper: QuizUserUIToDomainMapper,
    private val quizUserDomainToUIMapper: QuizUserDomainToUIMapper,
    private val userSubjectDomainToUIMapper: QuizUserSubjectDomainToUIMapper
) : QuizBaseViewModel() {

    val userSubjectsLiveData by QuizLiveDataDelegate<List<QuizUserSubjectUIModel>?>(null)
    val loadingLiveData by QuizLiveDataDelegate(true)

    fun getUserSubjects() {
        viewModelScope {
            val username = quizUserRepository.getUsernameIfLoggedIn()!!.username
            val result = userSubjectsRepository.getUserSubjects(username)
            userSubjectsLiveData.addValue(result.map { userSubjectDomainToUIMapper(it) })
            loadingLiveData.addValue(false)
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

    fun navigateToHome() {
        navigate(QuizDetailsFragmentDirections.actionGlobalHomeFragment())
    }

    fun navigateToLogin() {
        navigate(QuizDetailsFragmentDirections.actionGlobalLoginFragment())
    }

}
package com.space.quiz_app.presentation.ui.details.view_model

import com.space.quiz_app.common.extensions.viewModelScope
import com.space.quiz_app.common.utils.QuizLiveDataDelegate
import com.space.quiz_app.domain.usecase.quiz.GetUserSubjectsUseCase
import com.space.quiz_app.domain.usecase.user.LogOutUseCase
import com.space.quiz_app.presentation.feature.base.view_model.QuizBaseViewModel
import com.space.quiz_app.presentation.feature.model.mapper.user.QuizUserSubjectDomainToUIMapper
import com.space.quiz_app.presentation.feature.model.user.QuizUserSubjectUIModel
import com.space.quiz_app.presentation.ui.details.ui.QuizDetailsFragmentDirections

class QuizDetailsViewModel(
    private val userSubjectDomainMapper: QuizUserSubjectDomainToUIMapper,
    private val getSubjects: GetUserSubjectsUseCase,
    private val logOut: LogOutUseCase
) : QuizBaseViewModel() {

    val userSubjectsLiveData by QuizLiveDataDelegate<List<QuizUserSubjectUIModel>?>(null)
    val loadingLiveData by QuizLiveDataDelegate(true)

    fun getUserSubjects() {
        viewModelScope {
            userSubjectsLiveData.addValue(getSubjects().map { userSubjectDomainMapper(it) })
            loadingLiveData.addValue(false)
        }
    }

    fun logOutUser() {
        viewModelScope {
            logOut()
            navigateToLogin()
        }
    }

    fun navigateToHome() {
        navigate(QuizDetailsFragmentDirections.actionGlobalHomeFragment())
    }

    private fun navigateToLogin() {
        navigate(QuizDetailsFragmentDirections.actionGlobalLoginFragment())
    }

}
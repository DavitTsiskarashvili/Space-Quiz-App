package com.example.main_impl.details.view_model

import com.example.corecommon.common.extensions.viewModelScope
import com.example.corecommon.model.mapper.user.QuizUserSubjectDomainToUIMapper
import com.example.corecommon.model.user.QuizUserSubjectUIModel
import com.example.main_impl.domain.usecase.quiz.GetUserSubjectsUseCase
import com.example.main_impl.domain.usecase.user.LogOutUseCase
import com.space.quiz_app.presentation.ui.details.ui.QuizDetailsFragmentDirections

class QuizDetailsViewModel(
    private val userSubjectDomainMapper: QuizUserSubjectDomainToUIMapper,
    private val getSubjects: GetUserSubjectsUseCase,
    private val logOut: LogOutUseCase
) : com.example.corecommon.base.view_model.QuizBaseViewModel() {

    val userSubjectsLiveData by com.example.corecommon.common.utils.QuizLiveDataDelegate<List<QuizUserSubjectUIModel>?>(
        null
    )
    val loadingLiveData by com.example.corecommon.common.utils.QuizLiveDataDelegate(true)

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
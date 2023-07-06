package com.space.quiz_app.presentation.ui.home.view_model

import androidx.lifecycle.MutableLiveData
import com.space.quiz_app.common.extensions.viewModelScope
import com.space.quiz_app.common.utils.QuizLiveDataDelegate
import com.space.quiz_app.domain.usecase.user.CurrentUserUseCase
import com.space.quiz_app.domain.usecase.quiz.GetSubjectsUseCase
import com.space.quiz_app.domain.usecase.user.LogOutUseCase
import com.space.quiz_app.presentation.feature.base.view_model.QuizBaseViewModel
import com.space.quiz_app.presentation.feature.model.mapper.subject.QuizSubjectDomainMapper
import com.space.quiz_app.presentation.feature.model.mapper.user.QuizUserDomainToUIMapper
import com.space.quiz_app.presentation.feature.model.subject.QuizSubjectUIModel
import com.space.quiz_app.presentation.feature.model.user.QuizUserUIModel
import com.space.quiz_app.presentation.ui.home.ui.QuizHomeFragmentDirections

class QuizHomeViewModel(
    private val getSubjects: GetSubjectsUseCase,
    private val quizSubjectDomainMapper: QuizSubjectDomainMapper,
    private val quizUserDomainToUIMapper: QuizUserDomainToUIMapper,
    private val logOut: LogOutUseCase,
    private val currentUser: CurrentUserUseCase
) : QuizBaseViewModel() {

    val userLiveData by QuizLiveDataDelegate<QuizUserUIModel?>(null)
    val subjectsLiveData by QuizLiveDataDelegate<List<QuizSubjectUIModel>?>(null)
    val loadingLiveData by QuizLiveDataDelegate(true)
    private val selectedSubjectTitleLiveData = MutableLiveData<QuizSubjectUIModel>()

    fun getUser() {
        viewModelScope {
            currentUser()?.let { userLiveData.addValue(quizUserDomainToUIMapper(it)) }
        }
    }

    fun retrieveSubjects() {
        viewModelScope {
            subjectsLiveData.addValue(getSubjects().map {
                quizSubjectDomainMapper(it)
            })
            loadingLiveData.addValue(false)
        }
    }

    fun logOutUser(navigate: () -> Unit) {
        viewModelScope {
            logOut()
            navigate()
        }
    }

    fun onSubjectItemClick(subjectTitle: QuizSubjectUIModel) {
        selectedSubjectTitleLiveData.postValue(subjectTitle)
    }

    fun navigateToLogin() {
        navigate(QuizHomeFragmentDirections.actionGlobalLoginFragment())
    }

    fun navigateToGPA() {
        navigate(QuizHomeFragmentDirections.actionGlobalGpaFragment())
    }

    fun navigateToQuiz(subjectTitle: QuizSubjectUIModel) {
        navigate(QuizHomeFragmentDirections.actionGlobalQuestionsFragment(subjectTitle))
    }

}
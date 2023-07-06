package com.example.main_impl.home.view_model

import androidx.lifecycle.MutableLiveData
import com.example.corecommon.base.view_model.QuizBaseViewModel
import com.example.corecommon.common.extensions.viewModelScope
import com.example.corecommon.common.utils.QuizLiveDataDelegate
import com.example.corecommon.model.mapper.subject.QuizSubjectDomainMapper
import com.example.corecommon.model.mapper.user.QuizUserDomainToUIMapper
import com.example.corecommon.model.subject.QuizSubjectUIModel
import com.example.corecommon.model.user.QuizUserUIModel
import com.example.main_impl.domain.usecase.quiz.GetSubjectsUseCase
import com.example.main_impl.domain.usecase.user.CurrentUserUseCase
import com.example.main_impl.domain.usecase.user.LogOutUseCase
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
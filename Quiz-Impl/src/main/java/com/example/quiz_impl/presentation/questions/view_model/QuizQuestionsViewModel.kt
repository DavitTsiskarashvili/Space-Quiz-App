package com.example.quiz_impl.presentation.questions.view_model

import com.example.corecommon.base.view_model.QuizBaseViewModel
import com.example.corecommon.common.extensions.viewModelScope
import com.example.corecommon.common.utils.QuizLiveDataDelegate
import com.example.corecommon.model.mapper.question.QuizQuestionDomainMapper
import com.example.corecommon.model.mapper.subject.QuizSubjectUIToDomainMapper
import com.example.corecommon.model.questions.QuizQuestionUIModel
import com.example.corecommon.model.subject.QuizSubjectUIModel
import com.example.quiz_impl.domain.usecase.question.CalculateGPAUseCase
import com.example.quiz_impl.domain.usecase.question.GetQuestionsUseCase
import com.example.quiz_impl.domain.usecase.question.SaveUserScore
import com.example.quiz_impl.domain.usecase.question.SaveUserScoreUseCase
import com.example.quiz_impl.domain.usecase.user.CurrentUserUseCase

//import com.space.quiz_app.presentation.ui.home.ui.QuizHomeFragmentDirections

class QuizQuestionsViewModel(
    private val currentUser: CurrentUserUseCase,
    private val getQuestionsUseCase: GetQuestionsUseCase,
    private val saveUserScoreUseCase: SaveUserScoreUseCase,
    private val calculateGPA: CalculateGPAUseCase,
    private val questionsDomainMapper: QuizQuestionDomainMapper,
    private val subjectUIMapper: QuizSubjectUIToDomainMapper,
) : QuizBaseViewModel() {

    val quizLiveData by QuizLiveDataDelegate<QuizQuestionUIModel?>(null)
    val finishQuizLiveData by QuizLiveDataDelegate(false)
    val answerSelectedLiveData by QuizLiveDataDelegate(false)
    val userScoreLiveData by QuizLiveDataDelegate(0)
    val quizMaxQuestionLiveData by QuizLiveDataDelegate(0)
    val usernameLiveData by QuizLiveDataDelegate("")

    private val allQuestions = mutableListOf<QuizQuestionUIModel>()
    var questionIndex = 0

    init {
        getUsername()
    }

    fun getAllQuestionsBySubject(subjectTitle: String) {
        viewModelScope {
            allQuestions.addAll(getQuestionsUseCase(subjectTitle).map { questionsDomainMapper(it) })
            setQuizMaxQuestionsNumber()
            setQuestionAndAnswers()
        }
    }

    fun setQuestionAndAnswers() {
        val currentQuestion = allQuestions[questionIndex]
        quizLiveData.addValue(currentQuestion)
        if (questionIndex < allQuestions.lastIndex) {
            questionIndex += 1
            return
        }
        if (questionIndex == allQuestions.lastIndex) {
            finishQuiz()
        }
    }

    fun answerSelected() {
        answerSelectedLiveData.addValue(true)
    }

    fun submitQuizScore() {
        userScoreLiveData.addValue(userScoreLiveData.value?.plus(1) ?: 0)
    }

    fun saveUserScore(username: String, subject: QuizSubjectUIModel, score: Int) {
        viewModelScope {
            val subjectTitle = subjectUIMapper(subject)
            saveUserScoreUseCase(SaveUserScore(username, subjectTitle, score))
            calculateAndSaveGPA()
        }
    }

    private fun setQuizMaxQuestionsNumber() {
        val maxQuestion = allQuestions.size
        quizMaxQuestionLiveData.addValue(maxQuestion)
    }

    private fun finishQuiz() {
        finishQuizLiveData.addValue(true)
    }

    private fun getUsername() {
        viewModelScope {
            currentUser()?.let { usernameLiveData.addValue(it.username) }
        }
    }

    private suspend fun calculateAndSaveGPA() {
        usernameLiveData.value?.let { username ->
            calculateGPA(username)
        }
    }

//    fun navigateToHome() {
//        navigate(QuizHomeFragmentDirections.actionGlobalHomeFragment())
//    }

}
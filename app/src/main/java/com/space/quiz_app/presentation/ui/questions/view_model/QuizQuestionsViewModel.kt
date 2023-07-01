package com.space.quiz_app.presentation.ui.questions.view_model

import com.space.quiz_app.common.extensions.roundToSingleDecimal
import com.space.quiz_app.common.extensions.viewModelScope
import com.space.quiz_app.common.utils.QuizLiveDataDelegate
import com.space.quiz_app.domain.repository.QuizQuestionsRepository
import com.space.quiz_app.domain.repository.QuizUserRepository
import com.space.quiz_app.domain.repository.QuizUserSubjectsRepository
import com.space.quiz_app.presentation.feature.base.view_model.QuizBaseViewModel
import com.space.quiz_app.presentation.feature.model.mapper.question.QuizQuestionDomainMapper
import com.space.quiz_app.presentation.feature.model.mapper.subject.QuizSubjectUIToDomainMapper
import com.space.quiz_app.presentation.feature.model.questions.QuizQuestionUIModel
import com.space.quiz_app.presentation.feature.model.subject.QuizSubjectUIModel
import com.space.quiz_app.presentation.ui.home.ui.QuizHomeFragmentDirections

class QuizQuestionsViewModel(
    private val quizQuestionsRepository: QuizQuestionsRepository,
    private val quizUserSubjectsRepository: QuizUserSubjectsRepository,
    private val quizUserRepository: QuizUserRepository,
    private val questionsDomainMapper: QuizQuestionDomainMapper,
    private val quizSubjectUIToDomainMapper: QuizSubjectUIToDomainMapper,
) : QuizBaseViewModel() {

    //use cases
    // default values
    val questionState by QuizLiveDataDelegate<QuizQuestionUIModel?>(null)
    val answerState by QuizLiveDataDelegate<QuizQuestionUIModel?>(null)
    val finishQuizState by QuizLiveDataDelegate(false)
    val answerSelectedState by QuizLiveDataDelegate(false)
    val userScoreState by QuizLiveDataDelegate(0)
    val quizMaxQuestionState by QuizLiveDataDelegate(0)
    val usernameState by QuizLiveDataDelegate("")

    // viewModel shouldn't store all questions but one question per request
    private val allQuestions = mutableListOf<QuizQuestionUIModel>()
    var questionIndex = 0

    // ViewModel shouldn't store all questions in advance. Retrieve one question per time from a database.
    fun getAllQuestions(subjectTitle: String) {
        viewModelScope {
            val result = quizQuestionsRepository.getQuestionsFromDatabase((subjectTitle))
            allQuestions.addAll(result.map { questionsDomainMapper(it) })
            setQuizMaxQuestionsNumber()
            setQuestions()
        }
    }

    fun answerSelected() {
        answerSelectedState.addValue(true)
    }

    fun setQuestions() {
        val currentQuestion = allQuestions[questionIndex]
        questionState.addValue(currentQuestion)
        answerState.addValue(currentQuestion)
        if (questionIndex < allQuestions.lastIndex) {
            questionIndex += 1
            return
        }
        if (questionIndex == allQuestions.lastIndex) {
            finishQuiz()
        }
    }

    private fun setQuizMaxQuestionsNumber() {
        val maxQuestion = allQuestions.size
        quizMaxQuestionState.addValue(maxQuestion)
    }

    private fun finishQuiz() {
        finishQuizState.addValue(true)
    }

    fun submitQuizScore() {
        userScoreState.addValue(userScoreState.value?.plus(1) ?: 0)
    }

    init {
        getUsername()
    }

    fun saveUserScore(username: String, subject: QuizSubjectUIModel, score: Int) {
        viewModelScope {
            val subjectTitle = quizSubjectUIToDomainMapper(subject)
            quizUserSubjectsRepository.saveUserScore(username, score, subjectTitle)
            calculateAndSaveGPA()
        }
    }

    private fun getUsername() {
        viewModelScope {
            val username = quizUserRepository.getUsernameIfLoggedIn()
            username?.let { usernameState.addValue(it.username) }
        }
    }

    private suspend fun calculateAndSaveGPA() {
        usernameState.value?.let { username ->
            val userSubjectPercentages = mutableListOf<Float>()
            quizUserSubjectsRepository.getUserSubjects(username).forEach {
                userSubjectPercentages.add(it.score.toFloat() / it.questionsCount)
            }
            val gpa = userSubjectPercentages.average() * 4
            quizUserRepository.saveGPA(username, gpa.toFloat().roundToSingleDecimal())
        }
    }

    fun navigateToHome() {
        navigate(QuizHomeFragmentDirections.actionGlobalLoginFragment())
    }

}
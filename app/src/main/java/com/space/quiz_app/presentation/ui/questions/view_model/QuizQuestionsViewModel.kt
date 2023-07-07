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
    private val subjectUIMapper: QuizSubjectUIToDomainMapper,
) : QuizBaseViewModel() {

    val questionLiveData by QuizLiveDataDelegate<QuizQuestionUIModel?>(null)
    val answerLiveData by QuizLiveDataDelegate<QuizQuestionUIModel?>(null)
    val finishQuizLiveData by QuizLiveDataDelegate(false)
    val answerSelectedLiveData by QuizLiveDataDelegate(false)
    val userScoreLiveData by QuizLiveDataDelegate(0)
    val quizMaxQuestionLiveData by QuizLiveDataDelegate(0)
    val usernameLiveData by QuizLiveDataDelegate("")

    private val allQuestions = mutableListOf<QuizQuestionUIModel>()
    var questionIndex = 0

    fun getAllQuestionsBySubject(subjectTitle: String) {
        viewModelScope {
            val result = quizQuestionsRepository.getQuestionsByTitle((subjectTitle))
            allQuestions.addAll(result.map { questionsDomainMapper(it) })
            setQuizMaxQuestionsNumber()
            setQuestions()
        }
    }

    fun answerSelected() {
        answerSelectedLiveData.addValue(true)
    }

    fun setQuestions() {
        val currentQuestion = allQuestions[questionIndex]
        questionLiveData.addValue(currentQuestion)
        answerLiveData.addValue(currentQuestion)
        if (questionIndex < allQuestions.lastIndex) {
            questionIndex += 1
            return
        }
        if (questionIndex == allQuestions.lastIndex) {
            finishQuiz()
        }
    }

    init {
        getUsername()
    }

    fun submitQuizScore() {
        userScoreLiveData.addValue(userScoreLiveData.value?.plus(1) ?: 0)
    }

    fun saveUserScore(username: String, subject: QuizSubjectUIModel, score: Int) {
        viewModelScope {
            val subjectTitle = subjectUIMapper(subject)
            quizUserSubjectsRepository.saveUserScore(username, score, subjectTitle)
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
            val username = quizUserRepository.getUsernameIfLoggedIn()
            username?.let { usernameLiveData.addValue(it.username) }
        }
    }

    private suspend fun calculateAndSaveGPA() {
        usernameLiveData.value?.let { username ->
            val userSubjectPercentages = mutableListOf<Float>()
            quizUserSubjectsRepository.getUserSubjects(username).forEach {
                userSubjectPercentages.add(it.score.toFloat() / it.questionsCount)
            }
            val gpa = userSubjectPercentages.average() * 4
            quizUserRepository.saveGPA(username, gpa.toFloat().roundToSingleDecimal())
        }
    }

    fun navigateToHome() {
        navigate(QuizHomeFragmentDirections.actionGlobalHomeFragment())
    }

}
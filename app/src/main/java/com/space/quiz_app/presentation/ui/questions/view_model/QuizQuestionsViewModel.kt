package com.space.quiz_app.presentation.ui.questions.view_model

import com.space.quiz_app.common.extensions.viewModelScope
import com.space.quiz_app.domain.repository.QuizQuestionsRepository
import com.space.quiz_app.presentation.feature.base.view_model.QuizBaseViewModel
import com.space.quiz_app.presentation.feature.model.mapper.question.QuizQuestionDomainMapper
import com.space.quiz_app.presentation.feature.model.questions.QuizQuestionUIModel
import com.space.quiz_app.common.utils.QuizLiveDataDelegate
import com.space.quiz_app.presentation.ui.home.ui.QuizHomeFragmentDirections

class QuizQuestionsViewModel(
    private val quizQuestionsRepository: QuizQuestionsRepository,
    private val questionsDomainMapper: QuizQuestionDomainMapper
) : QuizBaseViewModel() {
    //use cases
    // default values
    val questionState by QuizLiveDataDelegate<QuizQuestionUIModel?>(null)
    val answerState by QuizLiveDataDelegate<QuizQuestionUIModel?>(null)
    val finishQuizState by QuizLiveDataDelegate(false)
    val answerSelectedState by QuizLiveDataDelegate(false)

    // ერთი კითხვა უნდა იყოს მარტო და არა ლისტი
    private val allQuestions = mutableListOf<QuizQuestionUIModel>()
     var questionIndex = 0

    // ViewModel shouldn't store all questions in advance. Retrieve one question per time from a database.
    fun getAllQuestions(subjectTitle: String) {
        viewModelScope {
            val result = quizQuestionsRepository.getQuestionsFromDatabase((subjectTitle))
            allQuestions.addAll(result.map { questionsDomainMapper(it) })
            nextQuestion()
        }
    }

    fun answerSelected() {
        answerSelectedState.addValue(true)
    }

    fun nextQuestion() {
        val currentQuestion = allQuestions[questionIndex]
        questionState.addValue(currentQuestion)
        answerState.addValue(currentQuestion)
        if (questionIndex < allQuestions.lastIndex) {
            questionIndex += 1
            return
        }
        if (questionIndex == allQuestions.lastIndex){
            finishQuiz()
        }
    }

    private fun finishQuiz(){
            finishQuizState.addValue(true)
    }

    fun navigateToHome() {
        navigate(QuizHomeFragmentDirections.actionGlobalLoginFragment())
    }

}
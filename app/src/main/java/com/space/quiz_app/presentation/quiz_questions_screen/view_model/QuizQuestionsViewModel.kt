package com.space.quiz_app.presentation.quiz_questions_screen.view_model

import com.space.quiz_app.common.extensions.viewModelScope
import com.space.quiz_app.domain.repository.QuizQuestionsRepository
import com.space.quiz_app.presentation.base.view_model.QuizBaseViewModel
import com.space.quiz_app.presentation.mapper.question.QuizQuestionDomainMapper
import com.space.quiz_app.presentation.model.questions.QuizQuestionUIModel
import com.space.quiz_app.presentation.quiz_home_screen.ui.QuizHomeFragmentDirections
import com.space.quiz_app.presentation.utils.QuizLiveDataDelegate

class QuizQuestionsViewModel(
    private val quizQuestionsRepository: QuizQuestionsRepository,
    private val questionsDomainMapper: QuizQuestionDomainMapper
) : QuizBaseViewModel() {
    //use cases
    // default values
    val questionState by QuizLiveDataDelegate<QuizQuestionUIModel?>(null)
    val answerState by QuizLiveDataDelegate<QuizQuestionUIModel?>(null)

    // ერთი კითხვა უნდა იყოს მარტო და არა ლისტი
    private val allQuestions = mutableListOf<QuizQuestionUIModel>()
    private var questionIndex = 0

    fun getQuestions(subjectTitle: String) {
        viewModelScope {
            val result = quizQuestionsRepository.getQuestionsFromDatabase((subjectTitle))
            allQuestions.addAll(result.map { questionsDomainMapper(it) })
            nextQuestion()
        }
    }

    fun nextQuestion() {
            val currentQuestion = allQuestions[questionIndex]
            questionState.addValue(currentQuestion)
            answerState.addValue(currentQuestion)
            if (questionIndex < allQuestions.size - 1){
                questionIndex += 1
            }
    }

    fun navigateToHome() {
        navigate(QuizHomeFragmentDirections.actionGlobalLoginFragment())
    }

}
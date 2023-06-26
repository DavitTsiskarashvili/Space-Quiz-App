package com.space.quiz_app.presentation.quiz_questions_screen.view_model

import com.space.quiz_app.common.extensions.viewModelScope
import com.space.quiz_app.domain.repository.QuizQuestionsRepository
import com.space.quiz_app.presentation.base.view_model.QuizBaseViewModel
import com.space.quiz_app.presentation.mapper.answer.QuizAnswerDomainMapper
import com.space.quiz_app.presentation.mapper.question.QuizQuestionDomainMapper
import com.space.quiz_app.presentation.model.questions.QuizQuestionUIModel
import com.space.quiz_app.presentation.quiz_home_screen.ui.QuizHomeFragmentDirections
import com.space.quiz_app.presentation.utils.QuizLiveDataDelegate

class QuizQuestionsViewModel(
    private val quizQuestionsRepository: QuizQuestionsRepository,
    private val answerDomainMapper: QuizAnswerDomainMapper
) : QuizBaseViewModel() {

    val questionState by QuizLiveDataDelegate<QuizQuestionUIModel?>(null)
    val answerState by QuizLiveDataDelegate<List<QuizQuestionUIModel.Answer>?>(emptyList())
    val loadingState by QuizLiveDataDelegate(true)


//
//    init {
//        getQuestions()
//    }
//
//    private fun getQuestions(subjectId: Int) {
//        viewModelScope {
//            val result = quizQuestionsRepository.getQuestionsFromDatabase(subjectId)
//            questionState.addValue(questionDomainMapper(result))
//        }
//    }

    fun getAnswers(subjectId: Int) {
        viewModelScope {
            val result = quizQuestionsRepository.getAnswersFromDatabase(subjectId)
            answerState.addValue(result.map {
                answerDomainMapper(it.correctAnswer)
            })
            loadingState.addValue(false)
        }
    }

    fun navigateToHome() {
        navigate(QuizHomeFragmentDirections.actionGlobalLoginFragment())
    }

}
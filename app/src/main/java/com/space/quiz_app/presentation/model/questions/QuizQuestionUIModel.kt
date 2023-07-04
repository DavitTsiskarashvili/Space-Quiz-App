package com.space.quiz_app.presentation.model.questions

import com.space.quiz_app.domain.model.questions.QuizQuestionDomainModel
import com.space.quiz_app.presentation.utils.QuizAnswerState

data class QuizQuestionUIModel(
    val questionTitle: String,
    val answers: MutableList<QuizQuestionDomainModel.AnswerDomain>,
    val correctAnswer: QuizQuestionDomainModel.AnswerDomain,
    val subjectId: Int,
    val questionIndex: Int,
    val isAnswered: Boolean,
    val isLastQuestion: Boolean,
    val subjectTitle: String
) {
    data class Answer(
        val answerOption: String,
        val isCorrect: Boolean,
        val answerSelectedState: QuizAnswerState
    )
}

package com.space.quiz_app.domain.model.questions

import com.space.quiz_app.presentation.utils.QuizAnswerState

data class QuizQuestionDomainModel(
    val questionTitle: String,
    val answers: MutableList<AnswerDomain>,
    val correctAnswer: AnswerDomain,
    val subjectId: Int,
    val questionIndex: Int,
    val isAnswered: Boolean,
    val isLastQuestion: Boolean,
    val subjectTitle: String
) {
    data class AnswerDomain(
        val answerOption: String,
        val isCorrect: Boolean,
        val answerSelectedState: QuizAnswerState
        = QuizAnswerState.ANSWER_NEUTRAL
    )
}

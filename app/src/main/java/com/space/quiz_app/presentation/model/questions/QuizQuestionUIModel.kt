package com.space.quiz_app.presentation.model.questions

import com.space.quiz_app.presentation.utils.QuizAnswerState

data class QuizQuestionUIModel(
    val questionTitle: String,
    val answers: List<String>,
    val correctAnswer: String,
    val subjectId: Int,
    val questionIndex: Int,
    val isAnswered: Boolean,
    val isLastQuestion: Boolean,
    val subjectTitle: String
)

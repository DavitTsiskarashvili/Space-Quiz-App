package com.space.quiz_app.presentation.feature.model.questions

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

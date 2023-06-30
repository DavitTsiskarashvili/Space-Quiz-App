package com.space.quiz_app.domain.model.questions

data class QuizQuestionDomainModel(
    val questionTitle: String,
    val answers: List<String>,
    val correctAnswer: String,
    val subjectId: Int,
    val questionIndex: Int,
    val isAnswered: Boolean,
    val isLastQuestion: Boolean,
    val subjectTitle: String
)

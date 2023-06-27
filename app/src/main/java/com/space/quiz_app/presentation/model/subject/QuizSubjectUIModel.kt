package com.space.quiz_app.presentation.model.subject

data class QuizSubjectUIModel(
    val id: Int,
    val quizTitle: String,
    val quizDescription: String,
    val quizIcon: String,
    val questionsCount: Int,
)
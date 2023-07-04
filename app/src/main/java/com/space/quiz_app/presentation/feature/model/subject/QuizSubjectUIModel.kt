package com.space.quiz_app.presentation.feature.model.subject

data class QuizSubjectUIModel(
    val id: Int,
    val quizTitle: String,
    val quizDescription: String,
    val quizIcon: String,
    val questionsCount: Int,
)
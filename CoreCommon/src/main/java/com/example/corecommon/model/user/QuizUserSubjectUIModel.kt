package com.example.corecommon.model.user

data class QuizUserSubjectUIModel(
    val quizTitle: String = "",
    val quizDescription: String = "",
    val quizIcon: String = "",
    val score: Int,
    val questionsCount: Int = 0
)
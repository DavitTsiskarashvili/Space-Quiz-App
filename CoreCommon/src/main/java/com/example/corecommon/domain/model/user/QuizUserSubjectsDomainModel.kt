package com.example.corecommon.domain.model.user

data class QuizUserSubjectsDomainModel(
    val quizTitle: String = "",
    var quizDescription: String = "",
    var quizIcon: String = "",
    val username: String = "",
    val score: Int,
    val questionsCount: Int = 0
)
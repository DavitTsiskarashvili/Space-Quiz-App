package com.space.quiz_app.domain.model.subject

import com.space.quiz_app.domain.model.questions.QuizQuestionDomainModel

data class QuizSubjectDomainModel(
    val id: Int,
    val quizTitle: String,
    val quizDescription: String,
    val quizIcon: String,
    val questionsCount: Int,
    val question: List<QuizQuestionDomainModel>? = null
)

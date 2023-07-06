package com.example.corecommon.domain.model.subject

import com.example.corecommon.domain.model.questions.QuizQuestionDomainModel

data class QuizSubjectDomainModel(
    val id: Int,
    val quizTitle: String,
    val quizDescription: String,
    val quizIcon: String,
    val questionsCount: Int,
    val question: List<QuizQuestionDomainModel>? = null
)

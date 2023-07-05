package com.space.quiz_app.domain.repository

import com.space.quiz_app.domain.model.questions.QuizQuestionDomainModel

interface QuizQuestionsRepository {
    suspend fun getQuestionsByTitle(subjectTitle: String): List<QuizQuestionDomainModel>
}
package com.example.corecommon.domain.repository

import com.example.corecommon.domain.model.questions.QuizQuestionDomainModel

interface QuizQuestionsRepository {
    suspend fun getQuestionsByTitle(subjectTitle: String): List<QuizQuestionDomainModel>
}
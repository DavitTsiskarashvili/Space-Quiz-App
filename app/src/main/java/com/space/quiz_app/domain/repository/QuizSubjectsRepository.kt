package com.space.quiz_app.domain.repository

import com.space.quiz_app.domain.model.subject.QuizSubjectDomainModel

interface QuizSubjectsRepository {
    suspend fun getSubjectsFromNetwork(): List<QuizSubjectDomainModel>

    suspend fun getSubjectsFromDatabase() : List<QuizSubjectDomainModel>
}
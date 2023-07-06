package com.example.corecommon.domain.repository

import com.example.corecommon.domain.model.subject.QuizSubjectDomainModel

interface QuizSubjectsRepository {
    suspend fun getSubjectsFromNetwork(): List<QuizSubjectDomainModel>

    suspend fun getSubjectsFromDatabase(): List<QuizSubjectDomainModel>
}
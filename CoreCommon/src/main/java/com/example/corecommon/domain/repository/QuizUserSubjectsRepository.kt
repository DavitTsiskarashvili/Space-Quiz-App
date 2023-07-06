package com.example.corecommon.domain.repository

import com.example.corecommon.data.local.entity.QuizUserSubjectEntity
import com.example.corecommon.domain.model.subject.QuizSubjectDomainModel
import com.example.corecommon.domain.model.user.QuizUserSubjectsDomainModel

interface QuizUserSubjectsRepository {
    suspend fun insertUserSubject(userSubject: QuizUserSubjectEntity)

    suspend fun getUserSubjectByTitle(username: String, quizTitle: String): QuizUserSubjectEntity?

    suspend fun updateUserSubject(userSubject: QuizUserSubjectEntity)

    suspend fun saveUserScore(username: String, score: Int, subject: QuizSubjectDomainModel)

    suspend fun getUserSubjects(username: String): List<QuizUserSubjectsDomainModel>
}
package com.space.quiz_app.domain.repository

import com.space.quiz_app.data.local.entity.QuizUserSubjectEntity
import com.space.quiz_app.domain.model.subject.QuizSubjectDomainModel

interface QuizUserSubjectsRepository {
    suspend fun insertUserSubject (userSubject: QuizUserSubjectEntity)

    suspend fun getUserSpecificSubject (username: String, quizTitle: String): QuizUserSubjectEntity?

    suspend fun updateUserSubject (userSubject: QuizUserSubjectEntity)

    suspend fun saveUserScore (username: String, score: Int, subject: QuizSubjectDomainModel)
}
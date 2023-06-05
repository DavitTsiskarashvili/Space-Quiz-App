package com.space.quiz_app.domain.repository

import com.space.quiz_app.data.remote.model.QuizQuestionsDTO
import retrofit2.Response

interface QuizSubjectsRepository {
    suspend fun getSubjects(): QuizQuestionsDTO
}
package com.space.quiz_app.data.repository

import com.space.quiz_app.data.local.dao.QuizQuestionsDao
import com.space.quiz_app.data.mapper.question.QuizQuestionEntityToDomainMapper
import com.space.quiz_app.domain.model.questions.QuizQuestionDomainModel
import com.space.quiz_app.domain.repository.QuizQuestionsRepository

class QuizQuestionsRepositoryImpl(
    private val questionsDao: QuizQuestionsDao,
    private val questionsEntityMapper: QuizQuestionEntityToDomainMapper
) : QuizQuestionsRepository {
    override suspend fun getQuestionsFromDatabase(subjectTitle: String): List<QuizQuestionDomainModel> {
        return questionsDao.getQuestions(subjectTitle).map { questionsEntityMapper(it) }
    }
}
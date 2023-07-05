package com.space.quiz_app.data.repository

import com.space.quiz_app.data.local.dao.QuizQuestionsDao
import com.space.quiz_app.data.mapper.question.QuizQuestionEntityToDomainMapper
import com.space.quiz_app.domain.model.questions.QuizQuestionDomainModel
import com.space.quiz_app.domain.repository.QuizQuestionsRepository

class QuizQuestionsRepositoryImpl(
    private val questionsDao: QuizQuestionsDao,
    private val questionsEntityMapper: QuizQuestionEntityToDomainMapper
) : QuizQuestionsRepository {
    override suspend fun getQuestionsByTitle(subjectTitle: String): List<QuizQuestionDomainModel> {
        return questionsDao.getQuestionsBySubject(subjectTitle).map { questionsEntityMapper(it) }
    }
}
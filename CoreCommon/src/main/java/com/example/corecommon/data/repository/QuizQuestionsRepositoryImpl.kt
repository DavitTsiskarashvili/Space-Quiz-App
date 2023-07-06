package com.example.corecommon.data.repository

import com.example.corecommon.data.local.dao.QuizQuestionsDao
import com.example.corecommon.data.mapper.question.QuizQuestionEntityToDomainMapper
import com.example.corecommon.domain.model.questions.QuizQuestionDomainModel
import com.example.corecommon.domain.repository.QuizQuestionsRepository

class QuizQuestionsRepositoryImpl(
    private val questionsDao: QuizQuestionsDao,
    private val questionsEntityMapper: QuizQuestionEntityToDomainMapper
) : QuizQuestionsRepository {
    override suspend fun getQuestionsByTitle(subjectTitle: String): List<QuizQuestionDomainModel> {
        return questionsDao.getQuestionsBySubject(subjectTitle).map { questionsEntityMapper(it) }
    }
}
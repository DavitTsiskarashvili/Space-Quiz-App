package com.space.quiz_app.data.repository

import com.space.quiz_app.data.local.dao.QuizQuestionsDao
import com.space.quiz_app.data.mapper.question.QuizQuestionEntityToDomainMapper
import com.space.quiz_app.domain.model.questions.QuizQuestionDomainModel
import com.space.quiz_app.domain.repository.QuizQuestionsRepository

class QuizQuestionsRepositoryImpl(
    private val questionsDao: QuizQuestionsDao,
    private val questionsEntityMapper: QuizQuestionEntityToDomainMapper
) : QuizQuestionsRepository {
//    override suspend fun getQuestionsFromDatabase(subjectId: Int): QuizQuestionDomainModel {
//        return questionsEntityMapper(questionsDao.getQuestions(subjectId))
//    }

    override suspend fun getAnswersFromDatabase(subjectId: Int): List<QuizQuestionDomainModel> {
        return questionsDao.getAnswers(subjectId).map { questionsEntityMapper(it) }
    }

}
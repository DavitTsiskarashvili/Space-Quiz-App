package com.space.quiz_app.domain.repository

import com.space.quiz_app.domain.model.questions.QuizQuestionDomainModel

interface QuizQuestionsRepository {
//    suspend fun getQuestionsFromDatabase(subjectId: Int) : QuizQuestionDomainModel

    suspend fun getAnswersFromDatabase(subjectId: Int) : List<QuizQuestionDomainModel>

}
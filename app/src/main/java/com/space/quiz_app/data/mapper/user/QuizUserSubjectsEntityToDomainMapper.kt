package com.space.quiz_app.data.mapper.user

import com.space.quiz_app.common.mapper.Mapper
import com.space.quiz_app.data.local.entity.QuizUserSubjectEntity
import com.space.quiz_app.domain.model.user.QuizUserSubjectsDomainModel

class QuizUserSubjectsEntityToDomainMapper :
    Mapper<QuizUserSubjectEntity, QuizUserSubjectsDomainModel> {
    override fun invoke(model: QuizUserSubjectEntity): QuizUserSubjectsDomainModel =
        with(model) {
            QuizUserSubjectsDomainModel(
                username = username,
                quizIcon = quizIcon,
                quizDescription = quizDescription,
                quizTitle = quizTitle,
                score = score,
                questionsCount = questionsCount
            )
        }
}
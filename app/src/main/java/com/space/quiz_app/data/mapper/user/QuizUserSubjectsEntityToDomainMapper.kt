package com.space.quiz_app.data.mapper.user

import com.space.quiz_app.common.mapper.Mapper
import com.space.quiz_app.data.local.entity.QuizUserSubjectEntity
import com.space.quiz_app.domain.model.user.QuizUserSubjectDomainModel

class QuizUserSubjectsEntityToDomainMapper :
    Mapper<QuizUserSubjectEntity, QuizUserSubjectDomainModel> {
    override fun invoke(model: QuizUserSubjectEntity): QuizUserSubjectDomainModel =
        with(model) {
            QuizUserSubjectDomainModel(
                username = username,
                quizIcon = quizIcon,
                quizDescription = quizDescription,
                quizTitle = quizTitle,
                score = score
            )
        }
}
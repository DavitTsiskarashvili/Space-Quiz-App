package com.space.quiz_app.data.mapper.user

import com.space.quiz_app.common.mapper.Mapper
import com.space.quiz_app.data.local.entity.QuizUserSubjectEntity
import com.space.quiz_app.domain.model.user.QuizUserSubjectDomainModel

class QuizUserSubjectsDomainToEntityMapper :
    Mapper<QuizUserSubjectDomainModel, QuizUserSubjectEntity> {
    override fun invoke(model: QuizUserSubjectDomainModel): QuizUserSubjectEntity =
        with(model) {
            QuizUserSubjectEntity(
                username = username,
                quizTitle = quizTitle,
                quizDescription = quizDescription,
                score = score,
                quizIcon = quizIcon
            )
        }
}


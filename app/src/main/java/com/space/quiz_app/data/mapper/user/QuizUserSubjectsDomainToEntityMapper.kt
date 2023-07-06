package com.space.quiz_app.data.mapper.user

import com.space.quiz_app.common.mapper.Mapper
import com.space.quiz_app.data.local.entity.QuizUserSubjectEntity
import com.space.quiz_app.domain.model.user.QuizUserSubjectsDomainModel

class QuizUserSubjectsDomainToEntityMapper :
    Mapper<QuizUserSubjectsDomainModel, QuizUserSubjectEntity> {
    override fun invoke(model: QuizUserSubjectsDomainModel): QuizUserSubjectEntity =
        with(model) {
            QuizUserSubjectEntity(
                username = username,
                quizTitle = quizTitle,
                quizDescription = quizDescription,
                score = score,
                quizIcon = quizIcon,
                questionsCount = questionsCount
            )
        }
}


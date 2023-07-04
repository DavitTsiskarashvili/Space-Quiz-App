package com.space.quiz_app.data.mapper.subject

import com.space.quiz_app.common.mapper.Mapper
import com.space.quiz_app.data.local.entity.QuizSubjectEntity
import com.space.quiz_app.domain.model.subject.QuizSubjectDomainModel

class QuizSubjectDomainToEntityMapper: Mapper<QuizSubjectDomainModel, QuizSubjectEntity> {
    override fun invoke(model: QuizSubjectDomainModel): QuizSubjectEntity =
        with(model) {
            QuizSubjectEntity(
                id = id,
                quizTitle = quizTitle,
                quizDescription = quizDescription,
                quizIcon = quizIcon,
                questionsCount = questionsCount,
            )
        }
}
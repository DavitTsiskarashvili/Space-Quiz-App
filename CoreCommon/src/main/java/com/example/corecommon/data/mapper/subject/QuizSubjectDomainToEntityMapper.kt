package com.example.corecommon.data.mapper.subject

import com.example.corecommon.data.local.entity.QuizSubjectEntity
import com.example.corecommon.domain.model.subject.QuizSubjectDomainModel

class QuizSubjectDomainToEntityMapper :
    com.example.corecommon.common.mapper.Mapper<QuizSubjectDomainModel, QuizSubjectEntity> {
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
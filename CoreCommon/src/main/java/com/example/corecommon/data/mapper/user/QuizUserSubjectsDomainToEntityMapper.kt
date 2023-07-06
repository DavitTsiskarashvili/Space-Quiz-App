package com.example.corecommon.data.mapper.user

import com.example.corecommon.data.local.entity.QuizUserSubjectEntity
import com.example.corecommon.domain.model.user.QuizUserSubjectsDomainModel

class QuizUserSubjectsDomainToEntityMapper :
    com.example.corecommon.common.mapper.Mapper<QuizUserSubjectsDomainModel, QuizUserSubjectEntity> {
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


package com.example.corecommon.data.mapper.user

import com.example.corecommon.data.local.entity.QuizUserSubjectEntity
import com.example.corecommon.domain.model.user.QuizUserSubjectsDomainModel

class QuizUserSubjectsEntityToDomainMapper :
    com.example.corecommon.common.mapper.Mapper<QuizUserSubjectEntity, QuizUserSubjectsDomainModel> {
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
package com.example.corecommon.model.mapper.user

import com.example.corecommon.domain.model.user.QuizUserSubjectsDomainModel
import com.example.corecommon.model.user.QuizUserSubjectUIModel

class QuizUserSubjectUIToDomainMapper :
    com.example.corecommon.common.mapper.Mapper<QuizUserSubjectUIModel, QuizUserSubjectsDomainModel> {
    override fun invoke(model: QuizUserSubjectUIModel): QuizUserSubjectsDomainModel =
        with(model) {
            QuizUserSubjectsDomainModel(
                quizIcon = quizIcon,
                quizDescription = quizDescription,
                quizTitle = quizTitle,
                score = score,
                questionsCount = questionsCount
            )
        }
}
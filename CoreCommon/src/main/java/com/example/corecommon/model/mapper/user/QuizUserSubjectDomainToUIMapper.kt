package com.example.corecommon.model.mapper.user

import com.example.corecommon.domain.model.user.QuizUserSubjectsDomainModel
import com.example.corecommon.model.user.QuizUserSubjectUIModel

class QuizUserSubjectDomainToUIMapper :
    com.example.corecommon.common.mapper.Mapper<QuizUserSubjectsDomainModel, QuizUserSubjectUIModel> {
    override fun invoke(model: QuizUserSubjectsDomainModel): QuizUserSubjectUIModel =
        with(model) {
            QuizUserSubjectUIModel(
                quizTitle = quizTitle,
                quizIcon = quizIcon,
                quizDescription = quizDescription,
                score = score,
                questionsCount = questionsCount
            )
        }
}
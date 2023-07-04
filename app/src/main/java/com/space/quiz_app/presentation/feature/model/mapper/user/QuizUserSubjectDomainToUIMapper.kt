package com.space.quiz_app.presentation.feature.model.mapper.user

import com.space.quiz_app.common.mapper.Mapper
import com.space.quiz_app.domain.model.user.QuizUserSubjectDomainModel
import com.space.quiz_app.presentation.feature.model.user.QuizUserSubjectUIModel

class QuizUserSubjectDomainToUIMapper : Mapper<QuizUserSubjectDomainModel, QuizUserSubjectUIModel> {
    override fun invoke(model: QuizUserSubjectDomainModel): QuizUserSubjectUIModel =
        with(model) {
            QuizUserSubjectUIModel(
                quizTitle = quizTitle,
                quizIcon = quizIcon,
                quizDescription = quizDescription,
                score = score
            )
        }
}
package com.space.quiz_app.presentation.feature.model.mapper.user

import com.space.quiz_app.common.mapper.Mapper
import com.space.quiz_app.domain.model.user.QuizUserSubjectDomainModel
import com.space.quiz_app.presentation.feature.model.user.QuizUserSubjectUIModel

class QuizUserSubjectUIToDomainMapper: Mapper<QuizUserSubjectUIModel, QuizUserSubjectDomainModel> {
    override fun invoke(model: QuizUserSubjectUIModel): QuizUserSubjectDomainModel =
        with(model) {
            QuizUserSubjectDomainModel(
                quizIcon = quizIcon,
                quizDescription = quizDescription,
                quizTitle = quizTitle,
                score = score
            )
        }
}
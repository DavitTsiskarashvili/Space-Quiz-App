package com.space.quiz_app.presentation.feature.model.mapper.user

import com.space.quiz_app.common.mapper.Mapper
import com.space.quiz_app.domain.model.user.QuizUserSubjectsDomainModel
import com.space.quiz_app.presentation.feature.model.user.QuizUserSubjectUIModel

class QuizUserSubjectDomainToUIMapper : Mapper<QuizUserSubjectsDomainModel, QuizUserSubjectUIModel> {
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
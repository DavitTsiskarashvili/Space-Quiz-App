package com.space.quiz_app.presentation.feature.model.mapper.user

import com.space.quiz_app.common.mapper.Mapper
import com.space.quiz_app.domain.model.user.QuizUserSubjectsDomainModel
import com.space.quiz_app.presentation.feature.model.user.QuizUserSubjectUIModel

class QuizUserSubjectUIToDomainMapper :
    Mapper<QuizUserSubjectUIModel, QuizUserSubjectsDomainModel> {
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
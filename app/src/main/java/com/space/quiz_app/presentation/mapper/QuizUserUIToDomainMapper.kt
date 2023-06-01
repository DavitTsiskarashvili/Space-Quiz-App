package com.space.quiz_app.presentation.mapper

import com.space.quiz_app.common.mapper.Mapper
import com.space.quiz_app.domain.model.QuizUserDomainModel
import com.space.quiz_app.presentation.model.QuizUserUIModel

class QuizUserUIToDomainMapper : Mapper<QuizUserUIModel, QuizUserDomainModel> {
    override fun invoke(model: QuizUserUIModel): QuizUserDomainModel =
        with(model) {
            QuizUserDomainModel(
                username = username,
                gpa = gpa,
                isLoggedIn = isLoggedIn
            )
        }
}
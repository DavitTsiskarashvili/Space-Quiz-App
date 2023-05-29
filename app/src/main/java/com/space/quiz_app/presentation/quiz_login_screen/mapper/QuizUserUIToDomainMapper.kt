package com.space.quiz_app.presentation.quiz_login_screen.mapper

import com.space.quiz_app.common.Mapper
import com.space.quiz_app.domain.model.QuizUserDomainModel
import com.space.quiz_app.presentation.quiz_login_screen.model.QuizUserUIModel

class QuizUserUIToDomainMapper : Mapper<QuizUserUIModel, QuizUserDomainModel> {
    override fun invoke(model: QuizUserUIModel): QuizUserDomainModel =
        with(model) {
            QuizUserDomainModel(
                username = username
            )
        }
}
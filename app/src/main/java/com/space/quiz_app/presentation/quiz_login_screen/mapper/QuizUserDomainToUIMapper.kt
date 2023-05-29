package com.space.quiz_app.presentation.quiz_login_screen.mapper

import com.space.quiz_app.common.Mapper
import com.space.quiz_app.domain.model.QuizUserDomainModel
import com.space.quiz_app.presentation.quiz_login_screen.model.QuizUserUIModel

class QuizUserDomainToUIMapper : Mapper<QuizUserDomainModel, QuizUserUIModel> {
    override fun invoke(model: QuizUserDomainModel): QuizUserUIModel =
        with(model) {
            QuizUserUIModel(
                username = username
            )
        }

}
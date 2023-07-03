package com.space.quiz_app.presentation.mapper.user

import com.space.quiz_app.common.mapper.Mapper
import com.space.quiz_app.domain.model.user.QuizUserDomainModel
import com.space.quiz_app.presentation.model.user.QuizUserUIModel

class QuizUserDomainToUIMapper : Mapper<QuizUserDomainModel, QuizUserUIModel> {
    override fun invoke(model: QuizUserDomainModel): QuizUserUIModel =
        with(model) {
            QuizUserUIModel(
                username = username,
                gpa = gpa,
                isLoggedIn = isLoggedIn
            )
        }
}
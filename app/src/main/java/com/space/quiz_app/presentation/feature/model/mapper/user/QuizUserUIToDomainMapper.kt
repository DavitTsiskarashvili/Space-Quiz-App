package com.space.quiz_app.presentation.feature.model.mapper.user

import com.space.quiz_app.common.mapper.Mapper
import com.space.quiz_app.domain.model.user.QuizUserDomainModel
import com.space.quiz_app.presentation.feature.model.user.QuizUserUIModel

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
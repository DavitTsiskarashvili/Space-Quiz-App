package com.presentation.mapper.user

import com.domain.model.user.QuizUserDomainModel
import com.mapper.Mapper
import com.presentation.model.user.QuizUserUIModel

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
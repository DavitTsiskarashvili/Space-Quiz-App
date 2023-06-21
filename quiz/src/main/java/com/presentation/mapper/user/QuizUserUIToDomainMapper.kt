package com.presentation.mapper.user

import com.domain.model.user.QuizUserDomainModel
import com.mapper.Mapper
import com.presentation.model.user.QuizUserUIModel

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
package com.presentation.mapper

import com.domain.model.QuizUserDomainModel
import com.mapper.Mapper
import com.presentation.model.QuizUserUIModel

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
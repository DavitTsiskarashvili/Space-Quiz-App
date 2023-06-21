package com.data.mapper


import com.data.local.QuizUserEntity
import com.domain.model.QuizUserDomainModel
import com.mapper.Mapper


class QuizUserEntityToDomainMapper : Mapper<QuizUserEntity, QuizUserDomainModel> {
    override fun invoke(model: QuizUserEntity): QuizUserDomainModel =
        with(model) {
            QuizUserDomainModel(
                username = username,
                gpa = gpa,
                isLoggedIn = isLoggedIn
            )
        }
}
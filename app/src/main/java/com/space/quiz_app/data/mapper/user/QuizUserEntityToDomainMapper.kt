package com.space.quiz_app.data.mapper.user

import com.space.quiz_app.common.mapper.Mapper
import com.space.quiz_app.data.local.QuizUserEntity
import com.space.quiz_app.domain.model.user.QuizUserDomainModel

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
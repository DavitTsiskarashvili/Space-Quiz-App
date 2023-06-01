package com.space.quiz_app.data.mapper

import com.space.quiz_app.common.mapper.Mapper
import com.space.quiz_app.data.local.QuizUserEntity
import com.space.quiz_app.domain.model.QuizUserDomainModel

class QuizUserDomainModelToEntityMapper : Mapper<QuizUserDomainModel, QuizUserEntity> {
    override fun invoke(model: QuizUserDomainModel): QuizUserEntity =
        with(model) {
            QuizUserEntity(
                username = username,
                gpa = gpa,
                isLoggedIn = isLoggedIn
            )
        }

}
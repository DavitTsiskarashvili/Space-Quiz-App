package com.data.mapper

import com.mapper.Mapper
import com.data.local.QuizUserEntity
import com.domain.model.QuizUserDomainModel

class QuizUserDomainToEntityMapper : Mapper<QuizUserDomainModel, QuizUserEntity> {
    override fun invoke(model: QuizUserDomainModel): QuizUserEntity =
        with(model) {
            QuizUserEntity(
                username = username,
                gpa = gpa,
                isLoggedIn = isLoggedIn
            )
        }
}
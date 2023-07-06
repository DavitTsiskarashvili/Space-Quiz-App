package com.example.corecommon.data.mapper.user

import com.example.corecommon.data.local.entity.QuizUserEntity
import com.example.corecommon.domain.model.user.QuizUserDomainModel

class QuizUserDomainToEntityMapper :
    com.example.corecommon.common.mapper.Mapper<QuizUserDomainModel, QuizUserEntity> {
    override fun invoke(model: QuizUserDomainModel): QuizUserEntity =
        with(model) {
            QuizUserEntity(
                username = username,
                gpa = gpa,
                isLoggedIn = isLoggedIn
            )
        }
}
package com.example.corecommon.data.mapper.user

import com.example.corecommon.data.local.entity.QuizUserEntity
import com.example.corecommon.domain.model.user.QuizUserDomainModel

class QuizUserEntityToDomainMapper :
    com.example.corecommon.common.mapper.Mapper<QuizUserEntity, QuizUserDomainModel> {
    override fun invoke(model: QuizUserEntity): QuizUserDomainModel =
        with(model) {
            QuizUserDomainModel(
                username = username,
                gpa = gpa,
                isLoggedIn = isLoggedIn
            )
        }
}
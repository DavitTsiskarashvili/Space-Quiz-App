package com.space.quiz_app.common.mapper

import com.space.quiz_app.data.mapper.user.QuizUserDomainToEntityMapper
import com.space.quiz_app.data.mapper.user.QuizUserEntityToDomainMapper
import com.space.quiz_app.data.remote.mapper.QuizQuestionsDTOMapper
import com.space.quiz_app.presentation.mapper.answer.QuizAnswerDomainMapper
import com.space.quiz_app.presentation.mapper.question.QuizQuestionDomainMapper
import com.space.quiz_app.presentation.mapper.user.QuizUserDomainToUIMapper
import com.space.quiz_app.presentation.mapper.user.QuizUserUIToDomainMapper
import org.koin.dsl.module

val mapperModule = module {
    single { QuizUserDomainToUIMapper() }
    single { QuizUserUIToDomainMapper() }
    single { QuizUserEntityToDomainMapper() }
    single { QuizUserDomainToEntityMapper() }
    single { QuizAnswersDTOMapper() }
    single { QuizAnswerDomainMapper() }
    single { QuizQuestionsDTOMapper(QuizAnswersDTOMapper()) }
    single { QuizQuestionDomainMapper(QuizAnswerDomainMapper()) }
}
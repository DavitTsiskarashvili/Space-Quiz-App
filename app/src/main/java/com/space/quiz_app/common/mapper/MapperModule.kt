package com.space.quiz_app.common.mapper

import com.space.quiz_app.data.mapper.QuizUserDomainModelToEntityMapper
import com.space.quiz_app.data.mapper.QuizUserEntityToDomainMapper
import com.space.quiz_app.presentation.mapper.QuizUserDomainToUIMapper
import com.space.quiz_app.presentation.mapper.QuizUserUIToDomainMapper
import org.koin.dsl.module

val mapperModule = module {
    single { QuizUserDomainToUIMapper() }
    single { QuizUserUIToDomainMapper() }
    single { QuizUserEntityToDomainMapper() }
    single { QuizUserDomainModelToEntityMapper() }
}
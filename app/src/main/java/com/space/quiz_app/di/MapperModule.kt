package com.space.quiz_app.di

import com.space.quiz_app.data.mapper.QuizUserDomainModelToEntityMapper
import com.space.quiz_app.data.mapper.QuizUserEntityToDomainMapper
import com.space.quiz_app.presentation.quiz_login_screen.mapper.QuizUserDomainToUIMapper
import com.space.quiz_app.presentation.quiz_login_screen.mapper.QuizUserUIToDomainMapper
import org.koin.dsl.module

val mapperModule = module {
    single { QuizUserDomainToUIMapper() }
    single { QuizUserUIToDomainMapper() }
    single { QuizUserEntityToDomainMapper() }
    single { QuizUserDomainModelToEntityMapper() }
}
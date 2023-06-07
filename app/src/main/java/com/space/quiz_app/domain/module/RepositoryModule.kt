package com.space.quiz_app.domain.module

import com.space.quiz_app.data.repository.QuizUserRepositoryImpl
import com.space.quiz_app.domain.repository.QuizUserRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<QuizUserRepository> { QuizUserRepositoryImpl(get(), get(), get()) }
}
package com.domain.module

import com.data.repository.QuizUserRepositoryImpl
import com.domain.repository.QuizUserRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<QuizUserRepository> { QuizUserRepositoryImpl(get(), get(), get()) }
}
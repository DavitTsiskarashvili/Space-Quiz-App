package com.domain.module

import com.data.repository.QuizSubjectsRepositoryImpl
import com.domain.repository.QuizSubjectsRepository
import com.domain.repository.QuizUserRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<QuizUserRepository> { QuizUserRepositoryImpl(get(), get(), get()) }
    single<QuizSubjectsRepository> { QuizSubjectsRepositoryImpl(get(), get()) }
}
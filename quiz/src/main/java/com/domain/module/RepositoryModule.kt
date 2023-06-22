package com.domain.module

import com.data.repository.QuizSubjectsRepositoryImpl
import com.domain.repository.QuizSubjectsRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<QuizSubjectsRepository> { QuizSubjectsRepositoryImpl(get(), get()) }
}
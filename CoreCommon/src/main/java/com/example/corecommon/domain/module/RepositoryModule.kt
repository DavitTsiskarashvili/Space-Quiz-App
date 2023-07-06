package com.space.quiz_app.domain.module

import com.example.corecommon.data.repository.QuizQuestionsRepositoryImpl
import com.example.corecommon.data.repository.QuizSubjectsRepositoryImpl
import com.example.corecommon.data.repository.QuizUserRepositoryImpl
import com.example.corecommon.data.repository.QuizUserSubjectRepositoryImpl
import com.example.corecommon.domain.repository.QuizQuestionsRepository
import com.example.corecommon.domain.repository.QuizSubjectsRepository
import com.example.corecommon.domain.repository.QuizUserRepository
import com.example.corecommon.domain.repository.QuizUserSubjectsRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<QuizUserRepository> { QuizUserRepositoryImpl(get(), get(), get()) }
    single<QuizSubjectsRepository> {
        QuizSubjectsRepositoryImpl(
            get(),
            get(),
            get(),
            get(),
            get(),
            get()
        )
    }
    single<QuizQuestionsRepository> { QuizQuestionsRepositoryImpl(get(), get()) }
    single<QuizUserSubjectsRepository> { QuizUserSubjectRepositoryImpl(get(), get()) }
}
package com.space.quiz_app.domain.module

import com.space.quiz_app.data.repository.QuizQuestionsRepositoryImpl
import com.space.quiz_app.data.repository.QuizSubjectsRepositoryImpl
import com.space.quiz_app.data.repository.QuizUserRepositoryImpl
import com.space.quiz_app.data.repository.QuizUserSubjectRepositoryImpl
import com.space.quiz_app.domain.repository.QuizQuestionsRepository
import com.space.quiz_app.domain.repository.QuizSubjectsRepository
import com.space.quiz_app.domain.repository.QuizUserRepository
import com.space.quiz_app.domain.repository.QuizUserSubjectsRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<QuizUserRepository> { QuizUserRepositoryImpl(get(), get(), get()) }
    single<QuizSubjectsRepository> { QuizSubjectsRepositoryImpl(get(), get(), get(), get(), get(), get() ) }
    single<QuizQuestionsRepository>  { QuizQuestionsRepositoryImpl( get(), get()) }
    single<QuizUserSubjectsRepository> { QuizUserSubjectRepositoryImpl( get(), get() ) }
}
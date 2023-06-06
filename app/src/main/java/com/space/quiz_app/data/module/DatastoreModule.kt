package com.space.quiz_app.data.module

import com.space.quiz_app.data.datastore.QuizUserDataStoreImpl
import com.space.quiz_app.data.datastore.QuizUserDatastore
import com.space.quiz_app.data.remote.mapper.QuizAnswersDTOMapper
import com.space.quiz_app.data.remote.mapper.QuizQuestionsDTOMapper
import com.space.quiz_app.data.repository.QuizSubjectsRepositoryImpl
import com.space.quiz_app.data.repository.QuizUsernameRepositoryImpl
import com.space.quiz_app.domain.repository.QuizSubjectsRepository
import com.space.quiz_app.domain.repository.QuizUsernameDatastoreRepository
import org.koin.dsl.module

val datastoreModule = module {
    single<QuizUserDatastore> { QuizUserDataStoreImpl(get()) }
    single<QuizUsernameDatastoreRepository> { QuizUsernameRepositoryImpl(get()) }
    single<QuizSubjectsRepository> {
        QuizSubjectsRepositoryImpl(
            get(), QuizQuestionsDTOMapper(
                QuizAnswersDTOMapper()
            )
        )
    }
}
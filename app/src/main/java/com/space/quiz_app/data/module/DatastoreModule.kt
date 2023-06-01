package com.space.quiz_app.data.module

import com.space.quiz_app.data.datastore.QuizUserDataStoreImpl
import com.space.quiz_app.data.datastore.QuizUserDatastore
import com.space.quiz_app.data.repository.QuizUsernameRepositoryImpl
import com.space.quiz_app.domain.repository.QuizUsernameDatastoreRepository
import org.koin.dsl.module

val datastoreModule = module {
    single<QuizUserDatastore> { QuizUserDataStoreImpl(get()) }
    single<QuizUsernameDatastoreRepository> {QuizUsernameRepositoryImpl(get())}
}
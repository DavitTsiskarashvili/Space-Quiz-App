package com.space.quiz_app

import android.app.Application
import com.space.quiz_app.data.module.dataBaseModule
import com.space.quiz_app.common.mapper.mapperModule
import com.space.quiz_app.data.module.datastoreModule
import com.space.quiz_app.domain.module.repositoryModule
import com.space.quiz_app.presentation.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class QuizApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@QuizApp)
            modules(
                dataBaseModule,
                viewModelModule,
                mapperModule,
                repositoryModule,
                datastoreModule
            )
        }
    }
}
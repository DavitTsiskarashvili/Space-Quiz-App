package com

import android.app.Application
import com.domain.module.repositoryModule
import com.presentation.model.module.viewModelModule
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
                repositoryModule,
                viewModelModule
            )
        }
    }
}
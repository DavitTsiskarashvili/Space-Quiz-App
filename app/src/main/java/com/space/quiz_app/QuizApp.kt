package com.space.quiz_app

import android.app.Application
import com.example.corecommon.data.local.module.dataBaseModule
import com.example.corecommon.data.mapper.module.databaseMapperModule
import com.example.corecommon.data.remote.service.module.networkModule
import com.example.main_impl.domain.usecase.useCaseModule
import com.space.quiz_app.domain.module.repositoryModule
import com.space.quiz_app.presentation.feature.module.UIModule
import com.space.quiz_app.presentation.feature.module.viewModelModule
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
                databaseMapperModule,
                viewModelModule,
                UIModule,
                repositoryModule,
                networkModule ,
                useCaseModule
            )
        }
    }
}
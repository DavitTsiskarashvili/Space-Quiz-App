package com.space.quiz_app

import android.app.Application
import com.space.quiz_app.di.dataBaseModule
import com.space.quiz_app.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                dataBaseModule,
                viewModelModule
            )
        }
    }
}
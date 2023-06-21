package com

import android.app.Application
import com.data.module.mapperModule
import com.domain.module.repositoryModule
import com.presentation.module.loginViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class LoginApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@LoginApp)
            modules(
                mapperModule,
                repositoryModule,
                loginViewModelModule
            )
        }
    }
}
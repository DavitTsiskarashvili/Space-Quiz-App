package com.space.quiz_app.domain.module

import com.space.quiz_app.domain.usecase.user.CheckUsernameValidityUseCase
import com.space.quiz_app.domain.usecase.user.LoginUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { LoginUseCase( get(), get()) }
    single { CheckUsernameValidityUseCase () }
}
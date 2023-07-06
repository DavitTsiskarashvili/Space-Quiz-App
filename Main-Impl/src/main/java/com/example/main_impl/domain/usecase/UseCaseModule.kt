package com.example.main_impl.domain.usecase

import com.example.main_impl.domain.usecase.quiz.GetSubjectsUseCase
import com.example.main_impl.domain.usecase.quiz.GetUserSubjectsUseCase
import com.example.main_impl.domain.usecase.user.LogOutUseCase
import com.example.main_impl.domain.usecase.user.LoginUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { LoginUseCase(userRepository = get(), usernameValidity = get()) }
    single { LogOutUseCase(userRepository = get(), userDomainMapper = get(), userUIMapper = get(), currentUser = get()) }
    single { GetUserSubjectsUseCase(userSubjectsRepository = get(), currentUser = get()) }
    single { GetSubjectsUseCase(quizSubjectsRepository = get()) }
}
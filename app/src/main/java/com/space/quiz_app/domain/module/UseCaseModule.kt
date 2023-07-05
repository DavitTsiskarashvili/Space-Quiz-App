package com.space.quiz_app.domain.module

import com.space.quiz_app.domain.usecase.question.CalculateGPAUseCase
import com.space.quiz_app.domain.usecase.question.GetQuestionsUseCase
import com.space.quiz_app.domain.usecase.question.SaveUserScoreUseCase
import com.space.quiz_app.domain.usecase.quiz.GetSubjectsUseCase
import com.space.quiz_app.domain.usecase.quiz.GetUserSubjectsUseCase
import com.space.quiz_app.domain.usecase.user.CheckUsernameValidityUseCase
import com.space.quiz_app.domain.usecase.user.CurrentUseCase
import com.space.quiz_app.domain.usecase.user.LogOutUseCase
import com.space.quiz_app.domain.usecase.user.LoginUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { LoginUseCase(get(), get()) }
    single { LogOutUseCase(get(), get(), get(), get()) }
    single { CheckUsernameValidityUseCase() }
    single { GetUserSubjectsUseCase(get(), get()) }
    single { CurrentUseCase(get()) }
    single { GetSubjectsUseCase(get()) }
    single { GetQuestionsUseCase(get()) }
    single { SaveUserScoreUseCase(get()) }
    single { CalculateGPAUseCase(get(), get()) }
}
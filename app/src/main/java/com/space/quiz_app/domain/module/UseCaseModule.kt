package com.space.quiz_app.domain.module

import com.space.quiz_app.domain.usecase.question.CalculateGPAUseCase
import com.space.quiz_app.domain.usecase.question.GetQuestionsUseCase
import com.space.quiz_app.domain.usecase.question.SaveUserScoreUseCase
import com.space.quiz_app.domain.usecase.quiz.GetSubjectsUseCase
import com.space.quiz_app.domain.usecase.quiz.GetUserSubjectsUseCase
import com.space.quiz_app.domain.usecase.user.CheckUsernameValidityUseCase
import com.space.quiz_app.domain.usecase.user.CurrentUserUseCase
import com.space.quiz_app.domain.usecase.user.LogOutUseCase
import com.space.quiz_app.domain.usecase.user.LoginUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { LoginUseCase(userRepository = get(), usernameValidity = get()) }
    single { LogOutUseCase(userRepository = get(), userDomainMapper = get(), userUIMapper = get(), currentUser = get()) }
    single { CheckUsernameValidityUseCase() }
    single { GetUserSubjectsUseCase(userSubjectsRepository = get(), currentUser = get()) }
    single { CurrentUserUseCase(userRepository = get()) }
    single { GetSubjectsUseCase(quizSubjectsRepository = get()) }
    single { GetQuestionsUseCase(questionsRepository = get()) }
    single { SaveUserScoreUseCase(userSubjectsRepository = get()) }
    single { CalculateGPAUseCase(quizUserRepository = get(), quizUserSubjectsRepository = get()) }
}
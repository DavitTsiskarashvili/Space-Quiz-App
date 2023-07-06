package com.example.quiz_impl.domain.module

import com.example.quiz_impl.domain.usecase.question.CalculateGPAUseCase
import com.example.quiz_impl.domain.usecase.question.GetQuestionsUseCase
import com.example.quiz_impl.domain.usecase.question.SaveUserScoreUseCase
import com.example.quiz_impl.domain.usecase.user.CurrentUserUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { CurrentUserUseCase(userRepository = get()) }
    single { GetQuestionsUseCase(questionsRepository = get()) }
    single { SaveUserScoreUseCase(userSubjectsRepository = get()) }
    single { CalculateGPAUseCase(quizUserRepository = get(), quizUserSubjectsRepository = get()) }
}
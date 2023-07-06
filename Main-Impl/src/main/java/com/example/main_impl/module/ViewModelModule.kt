package com.example.main_impl.module

import com.example.main_impl.details.view_model.QuizDetailsViewModel
import com.example.main_impl.home.view_model.QuizHomeViewModel
import com.example.main_impl.login.view_model.QuizLoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        QuizHomeViewModel(
            getSubjects = get(),
            quizSubjectDomainMapper = get(),
            quizUserDomainToUIMapper = get(),
            logOut = get(),
            currentUser = get()
        )
    }
    viewModel { QuizLoginViewModel(quizUserRepository = get(), loginUseCase = get()) }

    viewModel {
        QuizDetailsViewModel(
            userSubjectDomainMapper = get(),
            getSubjects = get(),
            logOut = get()
        )
    }
}
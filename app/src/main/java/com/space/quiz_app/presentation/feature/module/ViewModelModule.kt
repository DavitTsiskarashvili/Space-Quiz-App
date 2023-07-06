package com.space.quiz_app.presentation.feature.module

import com.example.main_impl.details.view_model.QuizDetailsViewModel
import com.example.main_impl.home.view_model.QuizHomeViewModel
import com.example.main_impl.login.view_model.QuizLoginViewModel
import com.example.quiz_impl.presentation.questions.view_model.QuizQuestionsViewModel
import com.space.quiz_app.presentation.ui.activity.view_model.QuizViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { QuizViewModel() }
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
        QuizQuestionsViewModel(
            currentUser = get(),
            getQuestionsUseCase = get(),
            saveUserScoreUseCase = get(),
            calculateGPA = get(),
            questionsDomainMapper = get(),
            subjectUIMapper = get()
        )
    }
    viewModel {
        QuizDetailsViewModel(
            userSubjectDomainMapper = get(),
            getSubjects = get(),
            logOut = get()
        )
    }
}
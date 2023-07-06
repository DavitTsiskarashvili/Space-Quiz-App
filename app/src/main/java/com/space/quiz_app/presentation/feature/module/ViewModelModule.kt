package com.space.quiz_app.presentation.feature.module

import com.space.quiz_app.presentation.ui.activity.view_model.QuizViewModel
import com.space.quiz_app.presentation.ui.details.view_model.QuizDetailsViewModel
import com.space.quiz_app.presentation.ui.home.view_model.QuizHomeViewModel
import com.space.quiz_app.presentation.ui.login.view_model.QuizLoginViewModel
import com.space.quiz_app.presentation.ui.questions.view_model.QuizQuestionsViewModel
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
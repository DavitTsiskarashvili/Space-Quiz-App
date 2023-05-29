package com.space.quiz_app.di

import com.space.quiz_app.presentation.quiz_activity.view_model.QuizActivityViewModel
import com.space.quiz_app.presentation.quiz_home_screen.view_model.QuizHomeViewModelQuiz
import com.space.quiz_app.presentation.quiz_login_screen.view_model.QuizLoginViewModel
import com.space.quiz_app.presentation.quiz_questions_screen.view_model.QuizQuestionsViewModelQuiz
import com.space.quiz_app.presentation.quiz_gpa_screen.view_model.QuizGPAViewModelQuiz
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { QuizActivityViewModel () }
    viewModel { QuizHomeViewModelQuiz () }
    viewModel { QuizLoginViewModel ( get(), get() ) }
    viewModel { QuizQuestionsViewModelQuiz () }
    viewModel { QuizGPAViewModelQuiz () }
}
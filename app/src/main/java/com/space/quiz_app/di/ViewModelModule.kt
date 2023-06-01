package com.space.quiz_app.di

import com.space.quiz_app.presentation.quiz_activity.QuizActivityViewModel
import com.space.quiz_app.presentation.quiz_home_screen.QuizHomeViewModel
import com.space.quiz_app.presentation.quiz_login_screen.QuizLoginViewModel
import com.space.quiz_app.presentation.quiz_questions_screen.QuizQuestionsViewModel
import com.space.quiz_app.presentation.taken_quiz_screen.QuizGPAViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { QuizActivityViewModel () }
    viewModel { QuizHomeViewModel () }
    viewModel { QuizLoginViewModel () }
    viewModel { QuizQuestionsViewModel () }
    viewModel { QuizGPAViewModel () }
}
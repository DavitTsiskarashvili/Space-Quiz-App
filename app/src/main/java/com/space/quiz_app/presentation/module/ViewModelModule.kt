package com.space.quiz_app.presentation.module

import com.space.quiz_app.presentation.quiz_activity.view_model.QuizActivityViewModel
import com.space.quiz_app.presentation.quiz_gpa_screen.view_model.QuizGPAViewModel
import com.space.quiz_app.presentation.quiz_home_screen.view_model.QuizHomeViewModel
import com.space.quiz_app.presentation.quiz_login_screen.view_model.QuizLoginViewModel
import com.space.quiz_app.presentation.quiz_questions_screen.view_model.QuizQuestionsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { QuizActivityViewModel () }
    viewModel { QuizHomeViewModel ( get() ) }
    viewModel { QuizLoginViewModel ( get(), get() ) }
    viewModel { QuizQuestionsViewModel () }
    viewModel { QuizGPAViewModel () }
}
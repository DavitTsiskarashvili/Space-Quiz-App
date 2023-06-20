package com.presentation.module

import com.presentation.quiz_gpa_screen.view_model.QuizGPAViewModel
import com.presentation.quiz_home_screen.view_model.QuizHomeViewModel
import com.presentation.quiz_questions_screen.view_model.QuizQuestionsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { QuizHomeViewModel(get(), get(), get(), get(), get()) }
    viewModel { QuizQuestionsViewModel() }
    viewModel { QuizGPAViewModel() }
}
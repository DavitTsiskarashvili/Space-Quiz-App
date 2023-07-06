package com.space.quiz_app.presentation.feature.module

import com.space.quiz_app.presentation.ui.activity.view_model.QuizViewModel
import com.space.quiz_app.presentation.ui.gpa.view_model.QuizGPAViewModel
import com.space.quiz_app.presentation.ui.home.view_model.QuizHomeViewModel
import com.space.quiz_app.presentation.ui.login.view_model.QuizLoginViewModel
import com.space.quiz_app.presentation.ui.questions.view_model.QuizQuestionsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { QuizViewModel() }
    viewModel { QuizHomeViewModel(get(), get(), get(), get(), get()) }
    viewModel { QuizLoginViewModel(get(), get(), get()) }
    viewModel { QuizQuestionsViewModel( get(), get(), get(), get(), get()) }
    viewModel { QuizGPAViewModel() }
}
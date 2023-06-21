package com.presentation.module

import com.presentation.view_model.QuizLoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginViewModelModule = module {
    viewModel { QuizLoginViewModel(get(), get(), get()) }

}
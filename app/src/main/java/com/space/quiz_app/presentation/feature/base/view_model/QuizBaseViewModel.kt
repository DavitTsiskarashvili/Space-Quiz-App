package com.space.quiz_app.presentation.feature.base.view_model

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.example.navigation_impl.navigation.NavigationCommand
import com.example.navigation_impl.navigation.QuizEvent
import com.space.quiz_app.common.utils.QuizLiveDataDelegate

abstract class QuizBaseViewModel : ViewModel() {

    val errorLiveData by QuizLiveDataDelegate<@receiver:StringRes Int?>(null)
    val navigationLiveData by QuizLiveDataDelegate<QuizEvent<NavigationCommand>?> (null)

    fun navigate(navDirections: NavDirections) {
        navigationLiveData.addValue(QuizEvent(NavigationCommand.ToDirection(navDirections)))
    }

    fun showError(@StringRes errorMessage: Int? = null){
        errorLiveData.addValue(errorMessage)
    }

}
package com.space.quiz_app.presentation.feature.base.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.space.quiz_app.presentation.feature.navigation.NavigationCommand
import com.space.quiz_app.common.utils.event.QuizEvent

abstract class QuizBaseViewModel : ViewModel() {

    private val _navigation = MutableLiveData<QuizEvent<NavigationCommand>>()
    val navigation: LiveData<QuizEvent<NavigationCommand>> get() = _navigation

    fun navigate(navDirections: NavDirections) {
        _navigation.value = QuizEvent(NavigationCommand.ToDirection(navDirections))
    }

    fun navigateBack() {
        _navigation.value = QuizEvent(NavigationCommand.Back)
    }
}
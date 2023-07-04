package com.space.quiz_app.presentation.feature.base.view_model

import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.space.quiz_app.common.utils.QuizLiveDataDelegate
import com.space.quiz_app.common.utils.event.QuizEvent
import com.space.quiz_app.presentation.feature.navigation.NavigationCommand

abstract class QuizBaseViewModel : ViewModel() {

    val errorState by QuizLiveDataDelegate<@receiver:StringRes Int?>(null)

    private val _navigation = MutableLiveData<QuizEvent<NavigationCommand>>()
    val navigation: LiveData<QuizEvent<NavigationCommand>> get() = _navigation

    fun navigate(navDirections: NavDirections) {
        _navigation.value = QuizEvent(NavigationCommand.ToDirection(navDirections))
    }

    fun submitError(@StringRes error: Int? = null){
        errorState.addValue(error)
    }

}
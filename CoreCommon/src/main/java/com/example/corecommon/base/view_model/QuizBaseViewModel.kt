package com.example.corecommon.base.view_model

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.example.corecommon.common.utils.QuizLiveDataDelegate
import com.example.corecommon.common.utils.navigation.NavigationCommand
import com.example.corecommon.common.utils.navigation.QuizEvent

abstract class QuizBaseViewModel : ViewModel() {

    val errorLiveData by QuizLiveDataDelegate<@receiver:StringRes Int?>(
        null
    )
    val navigationLiveData by QuizLiveDataDelegate<QuizEvent<NavigationCommand>?>(
        null
    )

    fun navigate(navDirections: NavDirections) {
        navigationLiveData.addValue(QuizEvent(NavigationCommand.ToDirection(navDirections)))
    }

    fun showError(@StringRes errorMessage: Int? = null) {
        errorLiveData.addValue(errorMessage)
    }

}
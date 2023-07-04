package com.space.quiz_app.common.utils

import androidx.lifecycle.LiveData
import kotlin.reflect.KProperty

class QuizLiveDataDelegate<T>(initialValue: T) : LiveData<T>(initialValue) {
    operator fun getValue(
        thisRef: Any,
        property: KProperty<*>
    ): QuizLiveDataDelegate<T> {
        return this
    }

    internal fun addValue(value: T) {
        postValue(value)
    }
}

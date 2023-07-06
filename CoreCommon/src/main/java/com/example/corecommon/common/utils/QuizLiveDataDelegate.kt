package com.example.corecommon.common.utils

import androidx.lifecycle.LiveData
import kotlin.reflect.KProperty

class QuizLiveDataDelegate<T>(initialValue: T) : LiveData<T>(initialValue) {
    operator fun getValue(
        thisRef: Any,
        property: KProperty<*>
    ): QuizLiveDataDelegate<T> {
        return this
    }

    fun addValue(value: T) {
        postValue(value)
    }
}

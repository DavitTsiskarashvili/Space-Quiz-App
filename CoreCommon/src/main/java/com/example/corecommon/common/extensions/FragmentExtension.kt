package com.example.corecommon.common.extensions

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.example.corecommon.common.utils.QuizLiveDataDelegate

fun <T> Fragment.observeValue(
    liveData: QuizLiveDataDelegate<T>,
    block: (T) -> Unit
): QuizLiveDataDelegate<T> {
    liveData.observe(viewLifecycleOwner) {
        block(it)
    }
    return liveData
}

fun <T> Fragment.observeNonNullValue(
    liveData: QuizLiveDataDelegate<T?>,
    block: (T) -> Unit
): QuizLiveDataDelegate<T?> {
    liveData.observe(viewLifecycleOwner) {
        it?.let {
            block(it)
        }
    }
    return liveData
}

fun Context.showToast(@StringRes messageResId: Int, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, messageResId, duration).show()
}
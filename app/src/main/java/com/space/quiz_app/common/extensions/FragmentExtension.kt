package com.space.quiz_app.common.extensions

import androidx.fragment.app.Fragment
import com.space.quiz_app.common.utils.QuizLiveDataDelegate
import com.space.quiz_app.presentation.ui.questions.custom_view.cancel_quiz_dialog.CancelQuizDialog
import com.space.quiz_app.presentation.ui.questions.custom_view.congrats_dialog.QuizCongratsDialog

fun <T> Fragment.observeLiveData(
    liveData: QuizLiveDataDelegate<T>,
    block: (T) -> Unit
): QuizLiveDataDelegate<T> {
    liveData.observe(viewLifecycleOwner) {
        block(it)
    }
    return liveData
}

fun <T> Fragment.observeLiveDataNonNull(
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

fun Fragment.showCongratsDialog(dialog: QuizCongratsDialog.() -> Unit): QuizCongratsDialog {
    return QuizCongratsDialog(requireContext()).apply(dialog)
}

fun Fragment.showCancelDialog(dialog: CancelQuizDialog.() -> Unit): CancelQuizDialog {
    return CancelQuizDialog(requireContext()).apply(dialog)
}
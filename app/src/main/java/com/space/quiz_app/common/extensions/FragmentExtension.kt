package com.space.quiz_app.common.extensions

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.space.quiz_app.presentation.ui.questions.custom_view.cancel_quiz_dialog.CancelQuizDialog
import com.space.quiz_app.presentation.ui.questions.custom_view.congrats_dialog.QuizCongratsDialog
import com.space.quiz_app.common.utils.QuizLiveDataDelegate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

fun Fragment.executeScope(
    coroutineContext: CoroutineContext = Dispatchers.Unconfined,
    lifecycleState: Lifecycle.State = Lifecycle.State.RESUMED,
    block: suspend () -> Unit
) {
    viewLifecycleOwner.lifecycleScope.launch(coroutineContext) {
        repeatOnLifecycle(lifecycleState) { block() }
    }
}

fun <T : Any?> Fragment.collectFlow(
    flow: Flow<T>,
    coroutineContext: CoroutineContext = Dispatchers.Unconfined,
    lifecycleState: Lifecycle.State = Lifecycle.State.RESUMED,
    block: (T) -> Unit
) {
    viewLifecycleOwner.lifecycleScope.launch(coroutineContext) {
        flow.flowWithLifecycle(lifecycle, lifecycleState).collect {
            block(it)
        }
    }
}

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
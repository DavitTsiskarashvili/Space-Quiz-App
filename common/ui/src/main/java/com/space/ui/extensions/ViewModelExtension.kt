package com.space.ui.extensions

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.launch

fun ViewModel.viewModelScope(block: suspend () -> Unit) {
    viewModelScope.launch { block() }
}
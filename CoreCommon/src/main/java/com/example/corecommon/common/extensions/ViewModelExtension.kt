package com.example.corecommon.common.extensions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun ViewModel.viewModelScope(block: suspend () -> Unit) {
    viewModelScope.launch (Dispatchers.IO) { block() }
}
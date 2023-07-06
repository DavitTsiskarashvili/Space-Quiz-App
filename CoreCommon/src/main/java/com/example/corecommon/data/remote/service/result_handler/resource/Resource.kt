package com.example.corecommon.data.remote.service.result_handler.resource

sealed class Resource<MODEL: Any>(val loader: Boolean) {
    data class Success<MODEL: Any>(val data: MODEL) : Resource<MODEL>(false)
    data class Error<T: Any>(val errorMessage: Throwable) : Resource<T>(false)
}
package com.space.quiz_app.data.remote.service.result_handler.resource

sealed class Resource<Any> {
    data class Success<Any>(val data: Any): Resource<Any>()
    data class Error(val errorMessage: String) : Throwable(errorMessage)
    data class Loader<T:Any>(val isLoading: Boolean): Resource<T>()
}
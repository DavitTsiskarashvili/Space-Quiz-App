package com.space.quiz_app.data.remote.service.result_handler.retrofit

import com.space.quiz_app.data.remote.service.result_handler.resource.Resource
import retrofit2.Response

inline fun <DTO> apiDataFetcher(
    apiResponse: () -> Response<DTO>,
): DTO {
    return try {
        val response = apiResponse.invoke()
        if (response.isSuccessful) {
            response.body()!!
        } else {
            throw Resource.Error(errorMessage = response.message())
        }
    } catch (e: Exception) {
        throw Resource.Error(errorMessage = e.message!!)
    }
}
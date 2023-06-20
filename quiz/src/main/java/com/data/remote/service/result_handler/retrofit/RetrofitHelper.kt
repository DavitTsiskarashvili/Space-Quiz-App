package com.data.remote.service.result_handler.retrofit

import com.data.remote.service.result_handler.resource.Resource
import retrofit2.Response

inline fun <DTO : Any, DOMAIN: Any> apiDataFetcher(
    mapper: (DTO) -> DOMAIN,
    apiResponse: () -> Response<DTO>
): Resource<DOMAIN> {
    return try {
        val response = apiResponse.invoke()
        if (response.isSuccessful) {
            Resource.Success(mapper(response.body()!!))
        } else {
            Resource.Error(Throwable(response.message()))
        }
    } catch (e: Exception) {
        Resource.Error(errorMessage = e)
    }
}
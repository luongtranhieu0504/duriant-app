package com.hieult.core.network.datasources

import com.hieult.core.network.common.DurianNetworkResult
import com.hieult.core.network.entities.DurianNetworkException
import retrofit2.Response

// apply for methods in ConfigRemoteDataSourceImpl
open class BaseRemoteDataSource {
    protected suspend fun <T: Any> callApi (call: suspend () -> Response<T>) : DurianNetworkResult<T> {
        val response: Response<T>
        try {
            response = call.invoke()
        } catch (e: Exception) {
            return DurianNetworkResult.Error(exception = e)
        }

        if (response.isSuccessful) {
            response.body()?.let {
                return DurianNetworkResult.Success(it)
            } ?: run {
                return DurianNetworkResult.Error(exception = Exception("body is empty"))
            }
        } else {
            response?.errorBody()?.toString()?.let {
                val durianNetWorkException = DurianNetworkException()
                durianNetWorkException.parse(it)
                return DurianNetworkResult.Error(durianNetWorkException)
            } ?: run {
                return DurianNetworkResult.Error(exception = Exception(response.message()))
            }
        }

    }
}
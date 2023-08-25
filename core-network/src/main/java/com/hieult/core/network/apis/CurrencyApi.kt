package com.hieult.core.network.apis

import com.hieult.core.network.entities.CurrencyRemote
import retrofit2.Response
import retrofit2.http.GET

interface CurrencyApi {
    @GET("/V1/directory/currency")
    suspend fun getCurrency(): Response<CurrencyRemote>
}
package com.hieult.core.network.apis

import com.hieult.core.network.entities.StoreConfigRemote
import retrofit2.Response
import retrofit2.http.GET

interface StoreConfigApi {

    @GET("/V1/store/storeConfigs")
    suspend fun getStore(): Response<List<StoreConfigRemote>>
}
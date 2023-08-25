package com.hieult.core.network.datasources

import com.hieult.core.network.apis.CurrencyApi
import com.hieult.core.network.apis.StoreConfigApi
import com.hieult.core.network.common.DurianNetworkResult
import com.hieult.core.network.entities.CurrencyRemote
import com.hieult.core.network.entities.StoreConfigRemote
import javax.inject.Inject

interface ConfigRemoteDataSource {
    suspend fun getCurrency(): DurianNetworkResult<CurrencyRemote>

    suspend fun getStore(): DurianNetworkResult<List<StoreConfigRemote>>
}

class ConfigRemoteDataSourceImpl @Inject constructor(private val currencyApi: CurrencyApi,
    private val storeConfigApi: StoreConfigApi) : BaseRemoteDataSource(), ConfigRemoteDataSource{
    override suspend fun getCurrency(): DurianNetworkResult<CurrencyRemote> {
        return callApi {
            currencyApi.getCurrency()
        }
    }

    override suspend fun getStore(): DurianNetworkResult<List<StoreConfigRemote>> {
        return callApi {
            storeConfigApi.getStore()
        }
    }

}
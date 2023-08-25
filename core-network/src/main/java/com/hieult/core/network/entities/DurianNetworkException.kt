package com.hieult.core.network.entities

import org.json.JSONObject

class DurianNetworkException: Throwable() {
    fun parse(exception: String){
        try {
            val json = JSONObject(exception)
            val message = json.get("message")
        }catch (e: Exception){

        }
    }
}
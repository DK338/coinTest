package com.example.cointest.network

import com.example.cointest.models.DataModel
import com.example.cointest.responses.DataResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v1/aggTrades")
    fun getDataResponse(@Query("symbol") symbol:String,@Query("limit") limit: Int): Call<List<DataModel>>

}
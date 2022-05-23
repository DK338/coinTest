package com.example.cointest.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.cointest.models.DataModel
import com.example.cointest.network.ApiClient
import com.example.cointest.network.ApiService
import com.example.cointest.responses.DataResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.create

class DataRepository {
    val apiService: ApiService = ApiClient().getRetrofit().create(ApiService::class.java)

    fun getDataResponses(): MutableLiveData<List<DataModel>>? {

        var data: MutableLiveData<List<DataModel>> = MutableLiveData()

        apiService.getDataResponse("BTCUSDT", 40).enqueue(object : retrofit2.Callback<List<DataModel>> {
                override fun onResponse(call: Call<List<DataModel>>, response: Response<List<DataModel>>) {
                    Log.d("success", response.body().toString())
                    data.value = response.body()
                }

                override fun onFailure(call: Call<List<DataModel>>, t: Throwable) {
                    Log.d("Fail", "noData")
                    data.value = null
                }
            })
        return data
    }
}
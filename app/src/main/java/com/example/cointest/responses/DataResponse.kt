package com.example.cointest.responses

import com.example.cointest.models.DataModel
import com.google.gson.annotations.SerializedName

data class DataResponse (

    @SerializedName("symbol")
    var symbol: String,

    @SerializedName("limit")
    var limit: Int,


)





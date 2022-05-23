package com.example.cointest.models

import com.google.gson.annotations.SerializedName

data class DataModel (

    @SerializedName("a")
    var nowID: Long,   //成交ID

    @SerializedName("p")
    var price: String, //成交價

    @SerializedName("q")
    var volume: String, //成交量

    @SerializedName("f")
    var firstID: Long,    //首次成交ID

    @SerializedName("l")
    var lastID: Long,    //首次成交ID

    @SerializedName("T")
    var time: Long,    //成交時間

    @SerializedName("m")
    var m: Boolean,

    @SerializedName("M")
    var best: Boolean

)

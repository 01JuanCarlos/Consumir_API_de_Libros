package com.jc.cl2.network.request

import com.google.gson.annotations.SerializedName

data class buscarlibroRequest(
    @SerializedName("title")
    var nombre:String
)

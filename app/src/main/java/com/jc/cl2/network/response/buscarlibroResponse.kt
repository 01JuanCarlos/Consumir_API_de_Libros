package com.jc.cl2.network.response

import com.google.gson.annotations.SerializedName

data class buscarlibroResponse(

    @SerializedName("total")
    var total:Int,
    @SerializedName("page")
    var page:Int,
    @SerializedName("books")
    var books:ArrayList<books>

)
data class books(
    @SerializedName("title")
    var nombre:String,
    @SerializedName("subtitle")
    var descripcion:String,
    @SerializedName("price")
    var precio:String,
    @SerializedName("image")
    var img:String,
    @SerializedName("url")
    var url:String
)

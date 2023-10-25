package com.jc.cl2.network


import com.jc.cl2.network.response.buscarlibroResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface CibertecApi {
    @GET("search/{title}")
    fun getlibro(@Path("title")title:String):
            Single<buscarlibroResponse>

}
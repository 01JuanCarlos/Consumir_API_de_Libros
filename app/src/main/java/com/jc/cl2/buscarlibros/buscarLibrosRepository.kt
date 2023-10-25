package com.jc.cl2.buscarlibros

import android.provider.ContactsContract.CommonDataKinds.Email
import com.jc.cl2.network.ApiService
import com.jc.cl2.network.request.buscarlibroRequest
import com.jc.cl2.network.response.buscarlibroResponse
import io.reactivex.Single

class buscarLibrosRepository {
    private val api=ApiService().apiService

    fun biscarlibro(title:String):Single<buscarlibroResponse>{
        return  api.getlibro(title)
    }

}
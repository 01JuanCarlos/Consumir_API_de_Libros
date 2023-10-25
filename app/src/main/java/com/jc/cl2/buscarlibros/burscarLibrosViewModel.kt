package com.jc.cl2.buscarlibros

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jc.cl2.database.Libro
import com.jc.cl2.network.response.books
import com.jc.cl2.network.response.buscarlibroResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class burscarLibrosViewModel:ViewModel() {

    private val repository=buscarLibrosRepository()
    private val disposable=CompositeDisposable()

    val libroService=MutableLiveData<Boolean>()
    val libroListService=MutableLiveData<ArrayList<books>>()


    fun libro(title:String){
        libroService(title)
    }

    private  fun libroService(title:String){
        disposable.add(
            repository.biscarlibro(title)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableSingleObserver<buscarlibroResponse>(){
                    override  fun onSuccess(t:buscarlibroResponse){

                        var dataRecicler=t.books
                        libroListService.value=dataRecicler
                        println("ENTROOOOOOOOOO:   "+dataRecicler.size)
                       /* for (elemento in dataRecicler) {
                            println(elemento)
                        }*/
                    }
                    override  fun onError(e:Throwable){
                        println(e)
                    }
                })
        )
    }
}


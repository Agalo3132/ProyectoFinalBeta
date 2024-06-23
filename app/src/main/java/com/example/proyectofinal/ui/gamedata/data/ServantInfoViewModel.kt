package com.example.proyectofinal.ui.gamedata.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.proyectofinal.model.basicInfo.servant.Servant
import com.example.proyectofinal.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ServantInfoViewModel (application: Application): AndroidViewModel(application) {

    //private val _servantsLiveData = MutableLiveData<List<Servant>>()
    val servantsLiveData: LiveData<MutableList<Servant>>
    //val servantsLiveData: LiveData<List<Servant>> get() = _servantsLiveData


    init {
        Repository(application)

        servantsLiveData = Repository.getLiveDataListaServants()
        getNextServant()

    }




    fun getNextServant() = viewModelScope.launch(Dispatchers.IO) {
        Repository.getNextServantsWithImages()
    }



}
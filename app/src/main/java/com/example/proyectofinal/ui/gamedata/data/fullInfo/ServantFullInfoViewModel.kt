package com.example.proyectofinal.ui.gamedata.data.fullInfo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectofinal.model.basicInfo.servant.Servant
import com.example.proyectofinal.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ServantFullInfoViewModel (application: Application): AndroidViewModel(application) {

    val servantsLiveData: LiveData<MutableList<Servant>>

    init {
        Repository(application)

        servantsLiveData = Repository.getLiveDataListaServants()
        getNextServant()

    }




    fun getNextServant() = viewModelScope.launch(Dispatchers.IO) {
        Repository.getNextServantsWithImages()
    }

}
package com.example.proyectofinal.ui.gamedata.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectofinal.model.basicInfo.commandCode.CommandCode
import com.example.proyectofinal.model.basicInfo.servant.Servant
import com.example.proyectofinal.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CommandCodeInfoViewModel (application: Application): AndroidViewModel(application) {

    val commandCodeLiveData: LiveData<MutableList<CommandCode>>


    init {
        Repository(application)

        commandCodeLiveData = Repository.getLiveDataListaCommandCodes()
        getNextCommandCode()

    }




    fun getNextCommandCode() = viewModelScope.launch(Dispatchers.IO) {
        Repository.getNextCommandCode()
    }
}
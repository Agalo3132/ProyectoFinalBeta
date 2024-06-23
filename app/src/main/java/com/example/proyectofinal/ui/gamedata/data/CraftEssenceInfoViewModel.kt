package com.example.proyectofinal.ui.gamedata.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectofinal.model.basicInfo.commandCode.CommandCode
import com.example.proyectofinal.model.basicInfo.craftEssence.CraftEssence
import com.example.proyectofinal.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CraftEssenceInfoViewModel (application: Application): AndroidViewModel(application) {

    val craftEssenceLiveData: LiveData<MutableList<CraftEssence>>


    init {
        Repository(application)

        craftEssenceLiveData = Repository.getLiveDataListaCraftEssence()
        getNextCraftEssence()

    }



    fun getNextCraftEssence() = viewModelScope.launch(Dispatchers.IO) {
        Repository.getNextCraftEssence()
    }

}
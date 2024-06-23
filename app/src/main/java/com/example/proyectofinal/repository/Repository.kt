package com.example.proyectofinal.repository

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import com.example.proyectofinal.model.basicInfo.commandCode.CommandCode
import com.example.proyectofinal.model.basicInfo.craftEssence.CraftEssence
import com.example.proyectofinal.model.basicInfo.servant.Servant
import com.example.proyectofinal.network.FateService
import com.example.proyectofinal.network.NetworkService
import kotlinx.coroutines.Dispatchers

object Repository {

    private lateinit var application: Application

    operator fun invoke(context: Context) {
        this.application = context.applicationContext as Application
        NetworkService(application)
    }


    suspend fun getNextServants() {
        NetworkService.getNextServant()
    }

    fun getLiveDataListaServants(): LiveData<MutableList<Servant>> {
        return NetworkService.getLiveDataListaServants()
    }


    suspend fun getNextServantsWithImages() {
        NetworkService.getNextServantWithImages()
    }

    suspend fun getNextCommandCode() {
        NetworkService.getNextCommandCode()
    }

    fun getLiveDataListaCommandCodes(): LiveData<MutableList<CommandCode>> {
        return NetworkService.getLiveDataListaCommandCodes()
    }


    suspend fun getNextCraftEssence() {
        NetworkService.getNextCraftEssence()
    }


    fun getLiveDataListaCraftEssence(): LiveData<MutableList<CraftEssence>> {
        return NetworkService.getLiveDataListaCraftEssence()
    }


    //QUITAR SI NO VA
    /**
    class Repository(private val fateService: FateService) {
        suspend fun getServants() = fateService.listaServants()
    }
    **/


}





package com.example.proyectofinal.network

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.proyectofinal.model.basicInfo.commandCode.CommandCode
import com.example.proyectofinal.model.basicInfo.craftEssence.CraftEssence
import com.example.proyectofinal.model.basicInfo.servant.Servant
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

object NetworkService {

    val TAG = "FateNexus"

    private lateinit var application: Application

    val URI_BASE = "https://api.atlasacademy.io/export/NA/"

    private val listaServants: MutableList<Servant> = mutableListOf()

    private val servantsLiveData = MutableLiveData(listaServants)

    private val listaCommandCodes: MutableList<CommandCode> = mutableListOf()


    private val listaCraftEssence: MutableList<CraftEssence> = mutableListOf()

    private val craftEssenceLiveData = MutableLiveData(listaCraftEssence)

    private val commandCodeLiveData = MutableLiveData(listaCommandCodes)

    private val gson = GsonBuilder().create()

    private val servicioFate = Retrofit.Builder().baseUrl(URI_BASE).addConverterFactory(GsonConverterFactory.create(gson)).build().create(FateService::class.java)



    //QUITAR SI NO VA
    /**
    object NetworkService {
        private val retrofit = Retrofit.Builder()
            .baseUrl("https://api.atlasacademy.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val fateService: FateService by lazy {
            retrofit.create(FateService::class.java)
        }
    }
    **/

    operator fun invoke(context: Context) {
        this.application = context.applicationContext as Application
    }

    fun getLiveDataListaServants (): LiveData<MutableList<Servant>> {
        return servantsLiveData
    }

    fun getLiveDataListaCommandCodes (): LiveData<MutableList<CommandCode>> {
        return commandCodeLiveData
    }

    fun getLiveDataListaCraftEssence (): LiveData<MutableList<CraftEssence>> {
        return craftEssenceLiveData
    }

    fun isConnected(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager != null) {
            val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    Log.i(TAG, "NetworkCapabilities.TRANSPORT_CELLULAR")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ) {
                    Log.i(TAG, "NetworkCapabilities.TRANSPORT_WIFI")
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                    Log.i(TAG, "NetworkCapabilities.TRANSPORT_ETHERNET")
                    return true
                }
            }
        }
        return false
    }


    suspend fun getNextCommandCode() {
        if (isConnected(application)) {
            try {
                val respuesta = servicioFate.getCommandCodes()
                if (respuesta.isSuccessful) {
                    val listado = respuesta.body()
                    if (listado != null) {
                        listaCommandCodes.addAll(listado)
                        Log.i(TAG, "Command codes actuales: ${listaCommandCodes.size}")
                        commandCodeLiveData.postValue(listaCommandCodes)
                    } else {
                        Log.e(TAG, "Error en el acceso al servicio: ${respuesta.errorBody()?.string()}")
                    }
                } else {
                    Log.e(TAG, "Error en el acceso al servicio: ${respuesta.errorBody()?.string()}")
                }
            } catch (e: IOException) {
                Log.e(TAG, "Error en el acceso al servicio: ${e.message}")
            }
        } else {
            Log.e(TAG, "Error de acceso a Internet")
        }
    }

    suspend fun getNextCraftEssence() {
        if (isConnected(application)) {
            try {
                val respuesta = servicioFate.getCraftEssence()
                if (respuesta.isSuccessful) {
                    val listado = respuesta.body()
                    if (listado != null) {
                        listaCraftEssence.addAll(listado)
                        Log.i(TAG, "Craft Essences actuales: ${listaCraftEssence.size}")
                        craftEssenceLiveData.postValue(listaCraftEssence)
                    } else {
                        Log.e(TAG, "Error en el acceso al servicio: ${respuesta.errorBody()?.string()}")
                    }
                } else {
                    Log.e(TAG, "Error en el acceso al servicio: ${respuesta.errorBody()?.string()}")
                }
            } catch (e: IOException) {
                Log.e(TAG, "Error en el acceso al servicio: ${e.message}")
            }
        } else {
            Log.e(TAG, "Error de acceso a Internet")
        }
    }




    suspend fun getNextServant() {
        if (isConnected(application)) {
            try {
                val respuesta = servicioFate.getServants()
                if (respuesta.isSuccessful) {
                    //val respuestaFate = respuesta.body()
                    val listado = respuesta.body()
                    if (listado != null) {
                        listaServants.addAll(listado)
                        Log.i(TAG, "Servants actuales: ${listaServants.size}")
                        servantsLiveData.postValue(listaServants)
                    } else {
                        Log.e(TAG, "Error en el acceso al servicio: ${respuesta.errorBody()?.string()}")
                    }
                } else {
                    Log.e(TAG, "Error en el acceso al servicio: ${respuesta.errorBody()?.string()}")
                }
            } catch (e: IOException) {
                Log.e(TAG, "Error en el acceso al servicio: ${e.message}")
            }
        } else {
            Log.e(TAG, "Error de acceso a Internet")
        }
    }



    suspend fun getNextServantWithImages() {
        if (isConnected(application)) {
            try {
                val respuestaServants = servicioFate.getServants()
                val respuestaImages = servicioFate.getNiceServants()

                if (respuestaServants.isSuccessful && respuestaImages.isSuccessful) {
                    val listaServants = respuestaServants.body() ?: emptyList()
                    val listaImages = respuestaImages.body() ?: emptyList()

                    /**
                    val servantsWithImages = listaServants.mapNotNull { servant ->
                        val imageItem = listaImages.find { it.id == servant.id }
                        if (imageItem != null && servant.overwriteName != null && servant.originalOverwriteName != null && servant.type != null && servant.flag != null && servant.className != null && servant.attribute != null) {
                            servant.copy(imageUrl = imageItem.image)
                        } else {
                            servant
                        }
                    }
                    **/


                    //ESTE VA
                    /**
                    val servantsWithImages = listaServants.mapNotNull { servant ->
                        val imageItem = listaImages.find { it.id == servant.id }
                        if (imageItem != null) {
                            if (servant.name != null && servant.overwriteName != null && servant.originalOverwriteName != null && servant.type != null && servant.flag != null && servant.className != null && servant.attribute != null) {
                                servant.copy(imageUrl = imageItem.image)
                            } else {
                                servant
                            }
                        } else {
                            servant
                        }
                    }
                    **/



                    val servantsWithImages = listaServants.mapNotNull { servant ->
                        val imageItem = listaImages.find { it.id == servant.id }
                        if (imageItem != null) {
                            //servant.copy(imageUrl = imageItem.image)
                            servant.copy(imageUrl = imageItem.image)
                        } else {
                            servant
                        }
                    }



                    servantsLiveData.postValue(servantsWithImages.toMutableList())

                    //POR ACABAR
                    //servantsLiveData.postValue(NetworkService.listaServants)

                } else {
                    Log.e(TAG, "Error en el acceso al servicio: ${respuestaServants.errorBody()?.string()}")
                }
            } catch (e: IOException) {
                Log.e(TAG, "Error en el acceso al servicio: ${e.message}")
            }
        } else {
            Log.e(TAG, "Error de acceso a Internet")
        }
    }







}
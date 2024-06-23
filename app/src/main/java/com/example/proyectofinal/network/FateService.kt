package com.example.proyectofinal.network

import com.example.proyectofinal.model.basicInfo.commandCode.CommandCode
import com.example.proyectofinal.model.basicInfo.craftEssence.CraftEssence
import com.example.proyectofinal.model.basicInfo.servant.Servant
import com.example.proyectofinal.model.fullInfo.servantImage.RespuestaServantItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface FateService {


    // Llamada al endpoint sin parámetros
    @GET("basic_servant.json")
    suspend fun getServants(): Response<List<Servant>>


    // Llamada al servicio directamente con la uri
    //@GET
    //suspend fun listaServants(@Url siguientes: String): Response<List<Servant>>

    @GET("nice_servant.json")
    suspend fun getNiceServants(): Response<List<RespuestaServantItem>>

    @GET("basic_command_code.json")
    suspend fun getCommandCodes(): Response<List<CommandCode>>

    @GET("basic_equip.json")
    suspend fun getCraftEssence(): Response<List<CraftEssence>>



}
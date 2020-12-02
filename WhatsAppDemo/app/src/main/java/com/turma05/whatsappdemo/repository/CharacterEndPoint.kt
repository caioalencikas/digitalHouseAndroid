package com.turma05.whatsappdemo.repository

import com.turma05.whatsappdemo.model.CharacterModel
import com.turma05.whatsappdemo.network.NetworkUtils
import retrofit2.http.GET

interface CharacterEndPoint {
    @GET("characters")
    suspend fun obterLista(): List<CharacterModel>

    companion object{
        val Endpoint: CharacterEndPoint by lazy {
            NetworkUtils.getRetrofitInstance().create(CharacterEndPoint::class.java)
        }
    }
}
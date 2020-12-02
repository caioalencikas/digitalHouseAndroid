package com.turma05.whatsappdemo.repository;

import retrofit2.http.GET;

public interface CharacterEndPoint {
    @GET("characters")
    suspend fun obterLista(): MutableList<CharacterModel>
}

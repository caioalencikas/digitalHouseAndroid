package com.turma05.whatsappdemo.repository

class CharacterRepository {

    private val client:CharacterEndPoint = CharacterEndPoint.Endpoint

    suspend fun obterLista() = client.obterLista()
}
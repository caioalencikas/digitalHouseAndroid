package com.digitalhouse.rickappgrid.api

import retrofit2.Call
import retrofit2.http.GET

interface Endpoint {

    @GET("character")
    fun getPersonagens() : Call<Resultado>
}

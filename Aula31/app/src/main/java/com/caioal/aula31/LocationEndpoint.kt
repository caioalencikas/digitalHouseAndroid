package com.caioal.aula31

import com.caioal.aula31.models.ApiResponseModel
import retrofit2.http.GET
import com.caioal.aula31.models.LocationModel
import retrofit2.Call
import retrofit2.http.Path

interface LocationEndpoint {

    @GET("location")
    fun getLocation(): Call<ApiResponseModel<LocationModel>>

    @GET("location/{id}")
    fun getDetail(@Path("id") id: Int): Call<LocationModel>
}
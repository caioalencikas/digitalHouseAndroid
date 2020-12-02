package com.example.chucknorris.repository

import com.example.chucknorris.NetworkUtils
import com.example.chucknorris.model.CategoryModel
import retrofit2.http.GET
import retrofit2.http.Query

interface CategoryEndpoint {
    @GET("categories")
    suspend fun getCategories(): List<String>

    @GET("random")
    suspend fun getJoke(@Query("category") categoryName: String?): CategoryModel

    companion object {
        val endpoint: CategoryEndpoint by lazy {
            NetworkUtils.getRetrofitInstance().create(CategoryEndpoint::class.java)
        }
    }
}
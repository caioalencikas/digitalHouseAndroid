package com.example.chucknorris.repository

class CategoryRepository {
    private val client = CategoryEndpoint.endpoint

    suspend fun getJoke(CategoryName: String?) = client.getJoke(CategoryName)
    suspend fun getCategories() = client.getCategories()
}
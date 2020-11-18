package com.caioal.aula31

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.caioal.aula31.models.ApiResponseModel
import com.caioal.aula31.models.LocationModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val client = getRetrofitInstance(BASE_URL)

        val endpoint = client.create(LocationEndpoint::class.java)

        endpoint.getLocation().enqueue(object: Callback<ApiResponseModel<LocationModel>> {
            override fun onFailure(call: Call<ApiResponseModel<LocationModel>>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<ApiResponseModel<LocationModel>>,
                response: Response<ApiResponseModel<LocationModel>>
            ) {
                val result = response.body()
                Toast.makeText(this@MainActivity, result!!.results[0].name, Toast.LENGTH_LONG).show()
            }

        })
    }

    fun getRetrofitInstance(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    companion object {
        const val BASE_URL = "https://rickandmortyapi.com/graphql/"
    }
}
package com.example.myapplication.api

import com.example.myapplication.model.UsersResponse
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface ApiInterface {

    @GET("users")
    fun getUsers(@Query("limit") limit: Int, @Query("skip") skip: Int): Call<UsersResponse>


    companion object {

        var apiInterface: ApiInterface? = null
        val BASE_URL: String = "https://dummyjson.com/"

        //Create the Retrofit service instance using the retrofit.
        fun getInstance(): ApiInterface {

            if (apiInterface == null) {

                val okHttpClient = OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS) // Set the connection timeout to 30 seconds
                    .readTimeout(30, TimeUnit.SECONDS)    // Set the read timeout to 30 seconds
                    .build()

                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()
                apiInterface = retrofit.create(ApiInterface::class.java)
            }
            return apiInterface!!
        }
    }

}
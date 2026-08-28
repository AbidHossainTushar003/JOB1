package com.example.job1.api


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {


    private const val BASE_URL =
        "https://api.escuelajs.co/api/v1/"


    val api: ProductApi by lazy {


        Retrofit.Builder()

            .baseUrl(BASE_URL)

            .addConverterFactory(
                GsonConverterFactory.create()
            )

            .build()

            .create(ProductApi::class.java)

    }

}
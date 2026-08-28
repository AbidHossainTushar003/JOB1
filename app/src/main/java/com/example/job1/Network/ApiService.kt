package com.example.job1.api


import com.example.job1.Model.Product
import retrofit2.http.GET


interface ProductApi {


    @GET("products")
    suspend fun getProducts(): List<Product>


}
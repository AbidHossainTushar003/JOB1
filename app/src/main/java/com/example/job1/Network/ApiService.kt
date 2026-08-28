package com.example.job1.api


import com.example.job1.Model.Product
import retrofit2.http.GET


/**
 * Retrofit interface defining the API endpoints for product-related operations.
 */
interface ProductApi {

    /**
     * Fetches a list of all products from the API.
     *
     * @return A list of [Product] objects.
     */
    @GET("products")
    suspend fun getProducts(): List<Product>


}
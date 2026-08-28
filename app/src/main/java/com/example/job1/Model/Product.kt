package com.example.job1.Model

/**
 * Represents a product in the system.
 *
 * @property id The unique identifier of the product.
 * @property title The name or title of the product.
 * @property price The cost of the product.
 * @property description A detailed description of the product.
 * @property images A list of URLs for the product's images.
 * @property category The category to which the product belongs.
 */
data class Product(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val images: List<String>,
    val category: Category
)

/**
 * Represents a category of products.
 *
 * @property id The unique identifier of the category.
 * @property name The name of the category.
 * @property image The URL of the image representing the category.
 */
data class Category(
    val id: Int,
    val name: String,
    val image: String
)
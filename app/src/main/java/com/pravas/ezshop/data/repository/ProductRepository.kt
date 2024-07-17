package com.pravas.ezshop.data.repository

import com.pravas.ezshop.data.api.ApiService
import com.pravas.ezshop.data.model.Product
import retrofit2.Response

class ProductRepository(private val apiService: ApiService) {
    suspend fun getAllProducts(): Response<List<Product>> = apiService.getAllProducts()
    suspend fun getCategories(): Response<List<String>> = apiService.getCategories()
}

package com.pravas.ezshop.data.repository

import com.pravas.ezshop.data.api.ApiService
import com.pravas.ezshop.data.model.Order
import retrofit2.Response

class OrderRepository(private val apiService: ApiService) {
    suspend fun placeOrder(order: Order): Response<Order> = apiService.placeOrder(order)
}

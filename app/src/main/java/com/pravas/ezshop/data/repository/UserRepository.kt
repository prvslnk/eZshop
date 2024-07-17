package com.pravas.ezshop.data.repository

// UserRepository.kt
import com.pravas.ezshop.data.api.ApiService
import com.pravas.ezshop.data.model.LoginRequest
import com.pravas.ezshop.data.model.LoginResponse
import com.pravas.ezshop.data.model.Order
import com.pravas.ezshop.data.model.User
import retrofit2.Response

class UserRepository(private val apiService: ApiService) {
    suspend fun register(user: User): Response<User> = apiService.register(user)
    suspend fun login(loginRequest: LoginRequest): Response<LoginResponse> = apiService.login(loginRequest)
    suspend fun updateUser(userId: Int, user: User): Response<User> = apiService.updateUser(userId, user)
    suspend fun getUserOrders(userId: Int): Response<List<Order>> = apiService.getUserOrders(userId)
}

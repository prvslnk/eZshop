package com.pravas.ezshop.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pravas.ezshop.data.api.ApiServiceInstance.apiService
import com.pravas.ezshop.data.repository.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CategoryViewModel() : ViewModel() {
    private val productRepository: ProductRepository = ProductRepository(apiService)
    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>> get() = _categories

    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        viewModelScope.launch {
            val response = productRepository.getCategories()
            if (response.isSuccessful) {
                _categories.value = response.body() ?: emptyList()
            } else {
                // Handle error
            }
        }
    }
}

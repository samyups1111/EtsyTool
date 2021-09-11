package com.sammydj.etsytool.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.sammydj.etsytool.repository.MainRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: MainRepository): ViewModel() {

    init {
        viewModelScope.launch {
            repository.refreshShopList()
        }
    }

    val ShopList = repository.shopList

    class MainViewModelFactory(val repository: MainRepository): ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return MainViewModel(repository) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}
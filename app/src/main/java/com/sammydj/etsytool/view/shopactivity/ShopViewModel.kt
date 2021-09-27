package com.sammydj.etsytool.view.shopactivity

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class ShopViewModel(private val repository: ShopRepository): ViewModel() {

    private var currentListingId: Long = 0
    fun getShop(id: Int)  = repository.getShopFromDatabase(id)
    var listings = repository.getListingsFromDatabase()
    var listingImages = repository.getListingImagesFromDatabase(currentListingId)

    fun setCurrentListing(listingId: Long) {
        currentListingId = listingId
    }

    fun getListingsFromNetwork(shopId: Int=0, start: Int=0) = viewModelScope.launch {
        repository.getListingsFromNetwork(shopId, start)
    }

    fun getListingImagesFromNetwork(listingId: Long = 0) = viewModelScope.launch {
        repository.getListingImagesFromNetwork(listingId)
    }

    fun clearDatabase() = viewModelScope.launch {
        repository.clearDatabase()
    }


    class ShopViewModelFactory(private val repository: ShopRepository): ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ShopViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return ShopViewModel(repository) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}
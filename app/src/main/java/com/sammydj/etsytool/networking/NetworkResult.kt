package com.sammydj.etsytool.networking

import com.sammydj.etsytool.model.shop.ShopRemote

sealed class NetworkResult<out T: Any> {
    data class Success<out T: Any>(val data: List<ShopRemote>): NetworkResult<T>()
    data class Error(val error: String): NetworkResult<Nothing>()

}

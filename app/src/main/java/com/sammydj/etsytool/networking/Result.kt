package com.sammydj.etsytool.networking

sealed class Result {
    data class Success(val data: List<ShopRemote>): Result()
    data class Error(val error: String): Result()
}

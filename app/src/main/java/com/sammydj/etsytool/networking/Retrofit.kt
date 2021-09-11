package com.sammydj.etsytool.networking

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface EtsyService {
    @GET("shops")
    suspend fun getShopList(): List<ShopRemote>
}

class Retrofit {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.etsy.com/v3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val service = retrofit.create(EtsyService::class.java)
}
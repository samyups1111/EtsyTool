package com.sammydj.etsytool.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class Retrofit {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://openapi.etsy.com/v2/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val service: EtsyService = retrofit.create(EtsyService::class.java)

    interface EtsyService {
        @GET("shops?limit=25")
        suspend fun getShopList(
            @Query("shop_name")
            shopName: String,
            @Query("offset")
            start: Int,
        ): retrofit2.Response<Results>?
    }
}
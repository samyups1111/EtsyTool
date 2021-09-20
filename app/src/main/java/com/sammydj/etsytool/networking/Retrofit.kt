package com.sammydj.etsytool.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

class Retrofit {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://openapi.etsy.com/v2/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val service: EtsyService = retrofit.create(EtsyService::class.java)

    interface EtsyService {
        @GET("shops?api_key=eeomp93xigld7jajqpvcyro5")
        suspend fun getShopList(): retrofit2.Response<Results>?
    }
}
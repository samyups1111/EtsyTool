package com.sammydj.etsytool.networking

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
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
        ): retrofit2.Response<ShopJson>?

        @GET("shops/{shop_id}/listings/active?limit=25")
        suspend fun getListings(
            @Path("shop_id")
            shopId: Int,
            @Query("offset")
            start: Int = 0
            ): retrofit2.Response<ListingsJson>?

        @GET("listings/{listing_id}/images?limit=25")
        suspend fun getListingImages(
            @Path("listing_id")
            listingId: Long
        ) : Response<ListingImagesJson>
    }
}
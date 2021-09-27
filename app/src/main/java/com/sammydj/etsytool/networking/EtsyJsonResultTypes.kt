package com.sammydj.etsytool.networking

import com.sammydj.etsytool.model.listing.ListingRemote
import com.sammydj.etsytool.model.listingimage.ListingImageRemote
import com.sammydj.etsytool.model.shop.ShopRemote

data class ShopJson(
    val count: Int,
    val results: List<ShopRemote>
)

data class ListingsJson(
    val count: Int,
    val results: List<ListingRemote>
)

data class ListingImagesJson(
    val count: Int,
    val results: List<ListingImageRemote>
)

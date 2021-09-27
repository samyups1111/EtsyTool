package com.sammydj.etsytool.model.listingimage

data class ListingImage(
    val listingImageId: Long?,
    val listingId: Int?,
    val isBlackOrWhite: Boolean?,
    val rank: Int?,
    val url75x75: String?,
    val url170x135: String?,
    val url_570xN: String?,
    val urlFullxFull: String?
)

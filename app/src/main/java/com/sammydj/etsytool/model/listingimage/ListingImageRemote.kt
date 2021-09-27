package com.sammydj.etsytool.model.listingimage

import com.squareup.moshi.Json

data class ListingImageRemote(
    @field:Json(name = "listing_image_id")
    val listingImageId: Long?,
    @field:Json(name = "listing_id")
    val listingId: Int?,
    @field:Json(name = "is_black_and_white")
    val isBlackOrWhite: Boolean?,
    @field:Json(name = "rank")
    val rank: Int?,
    @field:Json(name = "url_75x75")
    val url75x75: String?,
    @field:Json(name = "url_170x135")
    val url170x135: String?,
    @field:Json(name = "url_570xN")
    val url_570xN: String?,
    @field:Json(name = "url_fullxfull")
    val urlFullxFull: String?
)

fun List<ListingImageRemote>.toDatabaseModel(): List<ListingImageLocal> {
    return map {
        ListingImageLocal(
            listingImageId = it.listingImageId,
            listingId = it.listingId,
            isBlackOrWhite = it.isBlackOrWhite,
            rank = it.rank,
            url75x75 = it.url75x75,
            url170x135 = it.url170x135,
            url_570xN = it.url_570xN,
            urlFullxFull = it.urlFullxFull
        )
    }
}

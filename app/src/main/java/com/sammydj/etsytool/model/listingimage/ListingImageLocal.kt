package com.sammydj.etsytool.model.listingimage

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ListingImageLocal(
    @PrimaryKey
    val listingImageId: Long?,
    val listingId: Int?,
    val isBlackOrWhite: Boolean?,
    val rank: Int?,
    val url75x75: String?,
    val url170x135: String?,
    val url_570xN: String?,
    val urlFullxFull: String?
)

fun List<ListingImageLocal>.toDomainModel(): List<ListingImage> {
    return map {
        ListingImage(
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

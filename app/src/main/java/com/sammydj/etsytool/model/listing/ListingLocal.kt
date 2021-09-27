package com.sammydj.etsytool.model.listing

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ListingLocal(
    @PrimaryKey
    val listingId: Long?,
    val state: String?,
    val userId: Int?,
    val categoryId: Int?,
    val title: String?,
    val description: String?,
    val creationTsz: Float?,
    val endingTsz: Float?,
    val originalCreationTsz: Float?,
    val lastModifiedTsz: Float?,
    val price: String?,
    val currencyCode: String?,
    val quantity: Int?,
    val tags: List<String>?,
    val taxonomyId: Int?,
    val materials: List<String>?,
    val shopSectionId: Int?,
    val url: String?,
    val views: Int?,
    val numFavorers: Int?,
    val processingMin: Int?,
    val processingMax: Int?,
    val itemWeight: Int?,
    val itemWeightUnit: ItemWeightUnit?,
    val itemLength: Int?,
    val itemWidth: Int?,
    val itemHeight: Int?,
    val itemDimensionsUnit: ItemDimensionsUnit?,
    val style: List<String>?,
    val nonTaxable: Boolean?,
    val isCustomizable: Boolean?,
    val isDigital: Boolean?,
    val fileData: String?,
    val hasVariations: Boolean?
)

fun List<ListingLocal>.toDomainModel(): List<Listing> {
    return map {
        Listing(
            listingId = it.listingId,
            state = it.state,
            userId = it.userId,
            categoryId = it.categoryId,
            title = it.title,
            description = it.description,
            creationTsz = it.creationTsz,
            endingTsz = it.endingTsz,
            originalCreationTsz =it.originalCreationTsz,
            lastModifiedTsz = it.lastModifiedTsz,
            price = it.price,
            currencyCode = it.currencyCode,
            quantity = it.quantity,
            tags = it.tags,
            taxonomyId = it.taxonomyId,
            materials = it.materials,
            shopSectionId = it.shopSectionId,
            url = it.url,
            views = it.views,
            numFavorers = it.numFavorers,
            processingMin = it.processingMin,
            processingMax = it.processingMax,
            itemWeight = it.itemWeight,
            itemWeightUnit = it.itemWeightUnit,
            itemLength = it.itemLength,
            itemWidth = it.itemWidth,
            itemHeight = it.itemHeight,
            itemDimensionsUnit = it.itemDimensionsUnit,
            style = it.style,
            nonTaxable = it.nonTaxable,
            isCustomizable = it.isCustomizable,
            isDigital = it.isDigital,
            fileData = it.fileData,
            hasVariations = it.hasVariations
        )
    }
}

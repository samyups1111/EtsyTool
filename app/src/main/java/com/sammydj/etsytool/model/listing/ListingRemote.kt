package com.sammydj.etsytool.model.listing

import com.squareup.moshi.Json

data class ListingRemote(
    @field:Json(name = "listing_id")
    val listingId: Long?,
    @field:Json(name = "state")
    val state: String?,
    @field:Json(name = "user_id")
    val userId: Int?,
    @field:Json(name = "category_id")
    val categoryId: Int?,
    @field:Json(name = "title")
    val title: String?,
    @field:Json(name = "description")
    val description: String?,
    @field:Json(name = "creation_tsz")
    val creationTsz: Float?,
    @field:Json(name = "ending_tsz")
    val endingTsz: Float?,
    @field:Json(name = "original_creation_tsz")
    val originalCreationTsz: Float?,
    @field:Json(name = "last_modified_tsz")
    val lastModifiedTsz: Float?,
    @field:Json(name = "price")
    val price: String?,
    @field:Json(name = "currency_code")
    val currencyCode: String?,
    @field:Json(name = "quantity")
    val quantity: Int?,
    @field:Json(name = "tags")
    val tags: List<String>?,
    @field:Json(name = "taxonomy_id")
    val taxonomyId: Int?,
    @field:Json(name = "materials")
    val materials: List<String>?,
    @field:Json(name = "shop_section_id")
    val shopSectionId: Int?,
    @field:Json(name = "url")
    val url: String?,
    @field:Json(name = "views")
    val views: Int?,
    @field:Json(name = "num_favorers")
    val numFavorers: Int?,
    @field:Json(name = "processing_min")
    val processingMin: Int?,
    @field:Json(name = "processing_max")
    val processingMax: Int?,
    @field:Json(name = "item_weight")
    val itemWeight: Int?,
    @field:Json(name = "item_weight_unit")
    val itemWeightUnit: ItemWeightUnit?,
    @field:Json(name = "item_length")
    val itemLength: Int?,
    @field:Json(name = "item_width")
    val itemWidth: Int?,
    @field:Json(name = "item_height")
    val itemHeight: Int?,
    @field:Json(name = "item_dimensions_unit")
    val itemDimensionsUnit: ItemDimensionsUnit?,
    @field:Json(name = "style")
    val style: List<String>?,
    @field:Json(name = "non_taxable")
    val nonTaxable: Boolean?,
    @field:Json(name = "is_customizable")
    val isCustomizable: Boolean?,
    @field:Json(name = "is_digital")
    val isDigital: Boolean?,
    @field:Json(name = "file_data")
    val fileData: String?,
    @field:Json(name = "has_variations")
    val hasVariations: Boolean?
)

enum class ItemWeightUnit {
    @field:Json(name = "oz")
    OZ,
    @field:Json(name = "lb")
    LB,
    @field:Json(name = "g")
    G,
    @field:Json(name = "kg")
    KG
}

enum class ItemDimensionsUnit {
    @field:Json(name = "in")
    IN,
    @field:Json(name = "ft")
    FT,
    @field:Json(name = "mm")
    MM,
    @field:Json(name = "cm")
    CM,
    @field:Json(name = "m")
    M
}

fun List<ListingRemote>.asDatabaseModel(): List<ListingLocal> {
    return map { ListingLocal(
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
    ) }
}

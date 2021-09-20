package com.sammydj.etsytool.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sammydj.etsytool.model.Shop

@Entity
data class ShopLocal(
    @PrimaryKey
    val shopId: Int?,
    val shopName: String?,
    val userId: Int?,
    val creationTzs: Float?,
    var title: String?,
    var announcement: String?,
    var currencyCode: String?,
    var isVacation: Boolean?,
    var vacationMessage: String?,
    var saleMessage: String?,
    var digitalSaleMessage: String?,
    var lastUpdatedTsz: Float?,
    var listingActiveCount: Int?,
    var digitalListingCount: Int?,
    var loginName: String?,
    var acceptsCustomRequests: Boolean?,
    var policyWelcome: String?,
    var policyPayment: String?,
    var policyShipping: String?,
    var policyRefunds: String?,
    var policyAdditional: String?,
    var policySellerInfo: String?,
    var policyUpdatedTsz: Float?,
    var policyHasPrivateReceiptInfo: Boolean?,
    var vacationAutoreply: String?,
    var url: String?,
    var imageUrl760x100: String?,
    var numFavorers: Int?,
    var languages: List<String>?,
    var upcomingLocalEventId: Int?,
    var iconUrlFullxfull: String?,
    var isUsingStructuredPolicies: Boolean?,
    var hasOnboardedStructuredPolicies: Boolean?,
    var hasUnstructuredPolicies: Boolean?,
    var policyPrivacy: String?,
    var useNewInventoryEndpoints: Boolean?,
    var includeDisputeFormLink: Boolean?
)

fun List<ShopLocal>.asDomainModel(): List<Shop> {
    return map {
        Shop(
            shopId = it.shopId,
            shopName = it.shopName,
            userId = it.userId,
            creationTzs = it.creationTzs,
            title = it.title,
            announcement = it.announcement,
            currencyCode = it.currencyCode,
            isVacation = it.isVacation,
            vacationMessage = it.vacationMessage,
            saleMessage = it.saleMessage,
            digitalSaleMessage = it.digitalSaleMessage,
            lastUpdatedTsz = it.lastUpdatedTsz,
            listingActiveCount = it.listingActiveCount,
            digitalListingCount = it.digitalListingCount,
            loginName = it.loginName,
            acceptsCustomRequests = it.acceptsCustomRequests,
            policyWelcome = it.policyWelcome,
            policyPayment = it.policyPayment,
            policyShipping = it.policyShipping,
            policyRefunds = it.policyRefunds,
            policyAdditional = it.policyAdditional,
            policySellerInfo = it.policySellerInfo,
            policyUpdatedTsz = it.policyUpdatedTsz,
            policyHasPrivateReceiptInfo = it.policyHasPrivateReceiptInfo,
            vacationAutoreply = it.vacationAutoreply,
            url = it.url,
            imageUrl760x100 = it.imageUrl760x100,
            numFavorers = it.numFavorers,
            languages = it.languages,
            upcomingLocalEventId = it.upcomingLocalEventId,
            iconUrlFullxfull = it.iconUrlFullxfull,
            isUsingStructuredPolicies = it.isUsingStructuredPolicies,
            hasOnboardedStructuredPolicies = it.hasOnboardedStructuredPolicies,
            hasUnstructuredPolicies = it.hasUnstructuredPolicies,
            policyPrivacy = it.policyPrivacy,
            useNewInventoryEndpoints = it.useNewInventoryEndpoints,
            includeDisputeFormLink = it.includeDisputeFormLink
        )
    }
}

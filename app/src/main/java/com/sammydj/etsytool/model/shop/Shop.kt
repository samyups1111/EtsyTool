package com.sammydj.etsytool.model.shop

data class Shop(
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

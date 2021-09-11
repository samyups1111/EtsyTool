package com.sammydj.etsytool.networking

import com.sammydj.etsytool.database.ShopLocal
import com.squareup.moshi.Json

data class ShopRemote(

    @field:Json(name = "shop_id")
    val shopId: Int,
    @field:Json(name = "shop_name")
    val shopName: String,
    @field:Json(name = "user_id")
    val userId: Int,
    @field:Json(name = "creation_tzs")
    val creationTzs: Float,
    @field:Json(name = "title")
    var title: String,
    @field:Json(name = "announcement")
    var announcement: String,
    @field:Json(name = "currency_code")
    var currencyCode: String,
    @field:Json(name = "is_vacation")
    var isVacation: Boolean,
    @field:Json(name = "vacation_message")
    var vacationMessage: String,
    @field:Json(name = "sale_message")
    var saleMessage: String,
    @field:Json(name = "digital_sale_message")
    var digitalSaleMessage: String,
    @field:Json(name = "last_updated_tsz")
    var lastUpdatedTsz: Float,
    @field:Json(name = "listing_active_count")
    var listingActiveCount: Int,
    @field:Json(name = "digital_listing_count")
    var digitalListingCount: Int,
    @field:Json(name = "login_name")
    var loginName: String,
    @field:Json(name = "accepts_custom_requests")
    var acceptsCustomRequests: Boolean,
    @field:Json(name = "policy_welcome")
    var policyWelcome: String,
    @field:Json(name = "policy_payment")
    var policyPayment: String,
    @field:Json(name = "policy_shipping")
    var policyShipping: String,
    @field:Json(name = "policy_refunds")
    var policyRefunds: String,
    @field:Json(name = "policy_additional")
    var policyAdditional: String,
    @field:Json(name = "policy_seller_info")
    var policySellerInfo: String,
    @field:Json(name = "policy_updated_tsz")
    var policyUpdatedTsz: Float,
    @field:Json(name = "policy_has_private_receipt_info")
    var policyHasPrivateReceiptInfo: Boolean,
    @field:Json(name = "vacation_autoreply")
    var vacationAutoreply: String,
    @field:Json(name = "url")
    var url: String,
    @field:Json(name = "image_url_760x100")
    var imageUrl760x100: String,
    @field:Json(name = "num_favorers")
    var numFavorers: Int,
    @field:Json(name = "languages")
    var languages: List<String>,
    @field:Json(name = "upcoming_local_event_id")
    var upcomingLocalEventId: Int,
    @field:Json(name = "icon_url_fullxfull")
    var iconUrlFullxfull: String,
    @field:Json(name = "is_using_structured_policies")
    var isUsingStructuredPolicies: Boolean,
    @field:Json(name = "has_onboarded_structured_policies")
    var hasOnboardedStructuredPolicies: Boolean,
    @field:Json(name = "has_unstructured_policies")
    var hasUnstructuredPolicies: Boolean,
    @field:Json(name = "policy_privacy")
    var policyPrivacy: String,
    @field:Json(name = "use_new_inventory_endpoints")
    var useNewInventoryEndpoints: Boolean,
    @field:Json(name = "include_dispute_form_link")
    var includeDisputeFormLink: Boolean
)

fun List<ShopRemote>.asDatabaseModel(): List<ShopLocal> {
    return map {
        ShopLocal(
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



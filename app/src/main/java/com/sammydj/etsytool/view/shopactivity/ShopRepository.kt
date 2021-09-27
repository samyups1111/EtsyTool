package com.sammydj.etsytool.view.shopactivity

import android.util.Log
import androidx.lifecycle.Transformations
import com.sammydj.etsytool.database.ShopDao
import com.sammydj.etsytool.model.listing.asDatabaseModel
import com.sammydj.etsytool.model.listing.toDomainModel
import com.sammydj.etsytool.model.listingimage.toDatabaseModel
import com.sammydj.etsytool.model.listingimage.toDomainModel
import com.sammydj.etsytool.model.shop.toDomain
import com.sammydj.etsytool.networking.ListingImagesJson
import com.sammydj.etsytool.networking.ListingsJson
import com.sammydj.etsytool.networking.Retrofit
import retrofit2.Response

class ShopRepository(private val retrofit: Retrofit, private val shopDao: ShopDao) {

    private val TAG = "ShopRepository"

    fun getShopFromDatabase(id: Int) = Transformations.map(shopDao.getShopByIdFromDB(id)) { it!!.toDomain() }
    fun getListingsFromDatabase() = Transformations.map(shopDao.getShopListingsFromDB()) { it.toDomainModel() }
    fun getListingImagesFromDatabase(listingId: Long) = Transformations.map(shopDao.getListingImagesFromDB(listingId)) { it.toDomainModel() }

    suspend fun getListingsFromNetwork(shopId: Int, start: Int) {

        try {
            val response: Response<ListingsJson>? = retrofit.service.getListings(shopId, start)
            val code = response?.code()
            val body = response?.body()
            val list = body?.results

            Log.d(TAG, "listings code =${code}")

            if (list != null) {

                Log.d(TAG, "list not null")

                val convertedList = list.asDatabaseModel().toTypedArray()
                Log.d(TAG, "convertedlist success. size = ${convertedList.size}")


                shopDao.insertListingsToDB(*convertedList)


                Log.d(TAG, "listings NOT null AGain")
                Log.d(TAG, "remoteList.size = ${list.size}")
            } else {
                Log.d(TAG, "listings response = Network list is empty")
            }
        } catch (exception: Exception) {
            Log.d(TAG, "RP listings exception = " + exception.message.toString())
        }
    }

    suspend fun getListingImagesFromNetwork(listingId: Long) {
        try {
            val response: Response<ListingImagesJson>? = retrofit.service.getListingImages(listingId)
            val code = response?.code()
            val body = response?.body()
            val list = body?.results

            Log.d(TAG, "listingImages code =${code}")
            Log.d(TAG, "listimages.size = ${list?.size ?: -1}")

            if (list != null) {

                Log.d(TAG, "listimage is NOT null")
                val convertedList = list.toDatabaseModel().toTypedArray()
                shopDao.insertListingImagesToDB(*convertedList)
                Log.d(TAG, "listingImages NOT null")
                Log.d(TAG, "Images.size = ${list.size}")
            } else {
                Log.d(TAG, "listingImages response = Network list is empty")
            }
        } catch (exception: Exception) {
            Log.d(TAG, "RP listingImages exception = " + exception.message.toString())
        }
    }
    suspend fun clearDatabase() {
        shopDao.deleteAllListingImagesFromDB()
        shopDao.deleteAllListingsFromDB()
        shopDao.deleteAllShopsFromDB()
    }
}
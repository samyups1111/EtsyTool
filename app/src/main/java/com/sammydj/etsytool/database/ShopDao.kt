package com.sammydj.etsytool.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sammydj.etsytool.model.listing.ListingLocal
import com.sammydj.etsytool.model.listingimage.ListingImageLocal
import com.sammydj.etsytool.model.shop.ShopLocal

@Dao
interface ShopDao {
    @Query("SELECT * FROM ShopLocal")
    fun getShopListFromDB(): LiveData<List<ShopLocal>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShopListToDB(vararg shops: ShopLocal)

    @Query("DELETE FROM ShopLocal")
    suspend fun deleteAllShopsFromDB()

    @Query("SELECT * FROM ShopLocal WHERE shopId == :id")
    fun getShopByIdFromDB(id: Int): LiveData<ShopLocal>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListingsToDB(vararg listing: ListingLocal)

    @Query("SELECT * FROM ListingLocal")
    fun getShopListingsFromDB(): LiveData<List<ListingLocal>>

    @Query("DELETE FROM ListingLocal")
    suspend fun deleteAllListingsFromDB()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListingImagesToDB(vararg listingImages: ListingImageLocal)

    @Query("DELETE FROM ListingImageLocal")
    suspend fun deleteAllListingImagesFromDB()

    @Query("SELECT * FROM ListingImageLocal WHERE listingId == :listingId")
    fun getListingImagesFromDB(listingId: Long): LiveData<List<ListingImageLocal>>
}
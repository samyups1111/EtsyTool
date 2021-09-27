package com.sammydj.etsytool.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sammydj.etsytool.converters.Converters
import com.sammydj.etsytool.model.listing.Listing
import com.sammydj.etsytool.model.listing.ListingLocal
import com.sammydj.etsytool.model.listingimage.ListingImageLocal
import com.sammydj.etsytool.model.shop.ShopLocal

@Database(entities = [
    ShopLocal::class,
    ListingLocal::class,
    ListingImageLocal::class
                     ], version = 12, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ShopDatabase: RoomDatabase() {
    abstract val shopDao : ShopDao

    companion object {
        @Volatile
        private var INSTANCE : ShopDatabase? = null

        fun getDatabase(context: Context): ShopDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ShopDatabase::class.java,
                    "EtsyShopDatabase"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}




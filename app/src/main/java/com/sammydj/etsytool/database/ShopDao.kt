package com.sammydj.etsytool.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ShopDao {
    @Query("SELECT * FROM ShopLocal")
    fun getShops(): LiveData<List<ShopLocal>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(shops: List<ShopLocal>)
}
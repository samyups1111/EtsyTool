package com.sammydj.etsytool.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ShopDao {
    @Query("SELECT * FROM ShopLocal")
    fun getShops(): LiveData<List<ShopLocal>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg shops: ShopLocal)

    @Query("DELETE FROM ShopLocal")
    suspend fun deleteAll()
}
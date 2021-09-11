package com.sammydj.etsytool.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.sammydj.etsytool.database.ShopDao
import com.sammydj.etsytool.database.ShopDatabase
import com.sammydj.etsytool.database.asDomainModel
import com.sammydj.etsytool.model.Shop
import com.sammydj.etsytool.networking.Retrofit
import com.sammydj.etsytool.networking.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainRepository(private val retrofit: Retrofit, private val shopDao: ShopDao) {

    var shopList: LiveData<List<Shop>> = Transformations.map(shopDao.getShops()) {
        it.asDomainModel()
    }

    suspend fun refreshShopList() {
        withContext(Dispatchers.IO) {
            val networkList = retrofit.service.getShopList()

            shopDao.insertAll(networkList.asDatabaseModel())
        }
    }
}
package com.sammydj.etsytool.repository

import android.util.Log
import androidx.lifecycle.Transformations
import com.sammydj.etsytool.database.ShopDao
import com.sammydj.etsytool.database.asDomainModel
import com.sammydj.etsytool.networking.Retrofit
import com.sammydj.etsytool.networking.asDatabaseModel
import com.sammydj.etsytool.networking.Results
import retrofit2.Response

class MainRepository(private val retrofit: Retrofit, private val shopDao: ShopDao) {

    fun getListFromDatabase() = Transformations.map(shopDao.getShops()) {it.asDomainModel()}

    suspend fun clearDatabase() = shopDao.deleteAll()

    suspend fun refreshShopList() {

        try {
            val response: Response<Results>? = retrofit.service.getShopList()
            val code = response?.code()
            val body = response?.body()
            val list = body?.results
            Log.d("TAG", "RP1 list.size = ${list?.size}") // 25

            if (list != null) {

                Log.d("TAG", "RP2 list.size = ${list.size}") // 25
                val convertedList = list.asDatabaseModel().toTypedArray()
                shopDao.insertAll(*convertedList)
                Log.d("TAG", "RP3 convertedList.size = ${convertedList.size}") // 25

            } else {
                Log.d("TAG", "response = Network list is empty")
            }
        } catch (exception: Exception) {
            Log.d("Tag", "RP exception = " + exception.message.toString())
        }
    }
}
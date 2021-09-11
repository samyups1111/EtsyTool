package com.sammydj.etsytool

import android.app.Application
import com.sammydj.etsytool.database.ShopDatabase
import com.sammydj.etsytool.networking.Retrofit
import com.sammydj.etsytool.repository.MainRepository

class MainApplication: Application() {

    private val retrofit by lazy { Retrofit() }
    private val database by lazy { ShopDatabase.getDatabase(this) }
    val repository by lazy { MainRepository(retrofit, database.shopDao) }
}
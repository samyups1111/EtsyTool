package com.sammydj.etsytool

import android.app.Application
import android.content.Context
import com.sammydj.etsytool.database.ShopDatabase
import com.sammydj.etsytool.networking.Retrofit
import com.sammydj.etsytool.view.mainactivity.MainRepository
import com.sammydj.etsytool.view.shopactivity.ShopRepository

class MainApplication: Application() {

    companion object {
        lateinit var appContext : Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }

    private val retrofit by lazy { Retrofit() }
    private val database by lazy { ShopDatabase.getDatabase(this) }
    val mainRepository by lazy { MainRepository(retrofit, database.shopDao) }
    val shopRepository by lazy { ShopRepository(retrofit, database.shopDao) }
}
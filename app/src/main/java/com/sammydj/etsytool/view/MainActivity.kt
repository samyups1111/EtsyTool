package com.sammydj.etsytool.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.sammydj.etsytool.MainApplication
import com.sammydj.etsytool.R
import com.sammydj.etsytool.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mainTextView : TextView
    private val viewModel : MainViewModel by lazy {
        ViewModelProvider(this, MainViewModel.MainViewModelFactory((application as MainApplication).repository)).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainTextView = findViewById(R.id.main_textview)

        //getShops()
        Log.d("TAG", viewModel.ShopList.value?.size.toString())
    }

    private fun getShops() {

        viewModel.ShopList.observe(this, { shopList ->

            mainTextView.text = shopList[0].shopName

        })
    }
}
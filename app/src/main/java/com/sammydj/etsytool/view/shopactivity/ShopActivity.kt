package com.sammydj.etsytool.view.shopactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sammydj.etsytool.MainApplication
import com.sammydj.etsytool.R
import com.sammydj.etsytool.util.bindPictureToImageView

class ShopActivity : AppCompatActivity() {

    private val viewModel : ShopViewModel by lazy {
        ViewModelProvider(this, ShopViewModel.ShopViewModelFactory((application as MainApplication).shopRepository)).get(
            ShopViewModel::class.java)
    }
    private lateinit var shopNameTextView : TextView
    private var shopId = 0
    private lateinit var shopPicImageView : ImageView
    private lateinit var shopLocationTextView: TextView
    private lateinit var listingsTextView: ImageView
    private lateinit var getListingsButton: Button
    private lateinit var listingsRecyclerView : RecyclerView
    private lateinit var listingsRecyclerViewAdapter: ListingsRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)
        shopNameTextView = findViewById(R.id.shop_name_textview_shopxml)
        shopPicImageView = findViewById(R.id.pic_imageview_shopxml)
        shopLocationTextView = findViewById(R.id.location_textview_shopxml)
        listingsRecyclerView = findViewById(R.id.listings_recyclerview)
        listingsRecyclerViewAdapter = ListingsRecyclerViewAdapter(viewModel)
        setRecyclerView()
        shopId = intent.getIntExtra("shopClicked", 0)
        getShop()
        viewModel.getListingsFromNetwork(shopId, 0)
        loadListings()
    }

    private fun setRecyclerView() {
        listingsRecyclerView.apply {
            adapter = listingsRecyclerViewAdapter
            layoutManager = LinearLayoutManager(this@ShopActivity)
        }
    }

    private fun getShop() {
        viewModel.getShop(shopId).observe(this, Observer { shop ->

            shopNameTextView.text = shop.shopName
            bindPictureToImageView(shop?.imageUrl760x100, shopPicImageView, this)
        })
    }

    private fun loadListings() {
        viewModel.listings.observe(this, Observer { listings ->
            //viewModel.clearDatabase()
            Log.d("TAG", "listings.size = ${listings.size}")
            listingsRecyclerViewAdapter.updateList(listings)
            listingsRecyclerViewAdapter.notifyDataSetChanged()
        })
    }
}
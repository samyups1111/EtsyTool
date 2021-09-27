package com.sammydj.etsytool.view.shopactivity

import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sammydj.etsytool.R
import com.sammydj.etsytool.model.listing.Listing
import java.lang.Exception

class ListingsViewHolder(itemView: View, private val viewModel: ShopViewModel): RecyclerView.ViewHolder(itemView) {

    private val nameTextView: TextView = itemView.findViewById<TextView>(R.id.listing_name)
    private val listingImagesRecyclerView: RecyclerView = itemView.findViewById<RecyclerView>(R.id.listing_images_recyclerview)
    private val listingImagesRecyclerViewAdapter = ListingImagesRecyclerViewAdapter()

    init {
        setRecyclerView()
        viewModel.listingImages.observe(itemView.context as LifecycleOwner, Observer { images ->

            listingImagesRecyclerViewAdapter.updateListingImages(images)
            listingImagesRecyclerViewAdapter.notifyDataSetChanged()
            Log.d("TAG", "LVH imageList size = ${images.size}")
            try {
                Log.d("TAG", "LVH init observer image0 image id = ${images[0].listingImageId}")
                Log.d("TAG", "LVH init observer image0 listing id = ${images[0].listingId}")
                Log.d("TAG", "LVH observer image0 black or white? = ${images[0].isBlackOrWhite}")
                Log.d("TAG", "LVH init observer image1 image id = ${images[1].listingImageId}")
                Log.d("TAG", "LVH init observer image1 listing id = ${images[1].listingId}")
            } catch (e: Exception) {
                Log.d("TAG", "LVH Observer: catch: image is empty")
            }
        })
    }

    private fun setRecyclerView() {
        listingImagesRecyclerView.apply {
            adapter = listingImagesRecyclerViewAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    fun bind(listing: Listing) {

        viewModel.getListingImagesFromNetwork(listing.listingId ?: 0)
        viewModel.setCurrentListing(listing.listingId ?: 0L)
        Log.d("TAG", "LVH onBind: listingId = ${listing.listingId}")
        Log.d("TAG", "LVH onBind: listingId = ${listing.listingId}")

        listingImagesRecyclerViewAdapter.updateListingImages(viewModel.listingImages.value ?: emptyList())
        listingImagesRecyclerViewAdapter.notifyDataSetChanged()


        nameTextView.text = listing.title

    }
}
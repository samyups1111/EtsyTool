package com.sammydj.etsytool.view.shopactivity

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sammydj.etsytool.R
import com.sammydj.etsytool.model.listingimage.ListingImage

class ListingImagesRecyclerViewAdapter: RecyclerView.Adapter<ListingImagesViewHolder>() {

    private var listingImages = emptyList<ListingImage>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListingImagesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.listing_image_itemview, parent, false)
        return ListingImagesViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListingImagesViewHolder, position: Int) {
        val currentListing = listingImages[position]
        holder.bind(currentListing)
        Log.d("TAG", "LIrVA listingImages.size = ${listingImages.size}")
        Log.d("TAG", "LIrVA current listing id = ${currentListing.listingImageId}")
    }

    override fun getItemCount(): Int {
        return listingImages.size
    }

    fun updateListingImages(listOfImages: List<ListingImage>) {
        listingImages = listOfImages
    }
}
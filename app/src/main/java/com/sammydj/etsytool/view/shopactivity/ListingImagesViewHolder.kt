package com.sammydj.etsytool.view.shopactivity

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.sammydj.etsytool.R
import com.sammydj.etsytool.model.listingimage.ListingImage
import com.sammydj.etsytool.util.bindPictureToImageView

class ListingImagesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val currentImageView: ImageView = itemView.findViewById(R.id.current_listing_imageview)

    fun bind(listingImage: ListingImage) {
        Log.d("TAG", "LIVH url170 = ${listingImage.url170x135}")
        Log.d("TAG", "LIVH url75 = ${listingImage.url75x75}")
        Log.d("TAG", "LIVH urlfull = ${listingImage.urlFullxFull}")
        Log.d("TAG", "LIVH url570 = ${listingImage.url_570xN}")
        Log.d("TAG", "LIVH listing id = ${listingImage.listingId}")
        Log.d("TAG", "LIVH listingimage ID = ${listingImage.listingImageId}")
        bindPictureToImageView(listingImage.url_570xN, currentImageView, itemView.context, 570, 570)
    }
}
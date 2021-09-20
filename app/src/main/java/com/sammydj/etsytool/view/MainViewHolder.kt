package com.sammydj.etsytool.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sammydj.etsytool.R
import com.sammydj.etsytool.model.Shop

class MainViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    val picImageView = itemView.findViewById<ImageView>(R.id.pic_imageview)
    val shopNameTextView = itemView.findViewById<TextView>(R.id.shop_name_textview)
    val urlTextView = itemView.findViewById<TextView>(R.id.url_textview)
    val announcementTextView = itemView.findViewById<TextView>(R.id.announcement_textview)
    
    fun bind(shop: Shop) {

        shopNameTextView.text = shop.shopName
        urlTextView.text = shop.url
        announcementTextView.text = shop.announcement


    }
}
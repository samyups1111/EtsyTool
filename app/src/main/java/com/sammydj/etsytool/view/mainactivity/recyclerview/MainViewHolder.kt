package com.sammydj.etsytool.view.mainactivity.recyclerview

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sammydj.etsytool.R
import com.sammydj.etsytool.view.shopactivity.ShopActivity
import com.sammydj.etsytool.model.shop.Shop
import com.sammydj.etsytool.util.bindPictureToImageView

class MainViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    val picImageView = itemView.findViewById<ImageView>(R.id.pic_imageview)
    val shopNameTextView = itemView.findViewById<TextView>(R.id.shop_name_textview)
    val titleTextView = itemView.findViewById<TextView>(R.id.title_textview)
    val faveTextView = itemView.findViewById<TextView>(R.id.fave_textview)
    
    fun bind(shop: Shop) {

        shopNameTextView.text = shop.shopName
        titleTextView.text = shop.title
        faveTextView.text = shop.numFavorers.toString()
        bindPictureToImageView(shop.iconUrlFullxfull, picImageView, itemView.context, 400, 400)

        itemView.setOnClickListener {
            val shopIntent = Intent(itemView.context, ShopActivity::class.java)
            shopIntent.putExtra("shopClicked", shop.shopId!!)
            itemView.context.startActivity(shopIntent)
        }
    }
}
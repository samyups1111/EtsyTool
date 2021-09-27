package com.sammydj.etsytool.util

import android.content.Context
import android.widget.ImageView
import com.sammydj.etsytool.R
import com.squareup.picasso.Picasso

fun bindPictureToImageView(pic: String?, imageView: ImageView, context: Context, width: Int=800, height: Int=200) {

    Picasso.with(context)
        .load(pic)
        .resize(width, height)
        .placeholder(R.drawable.ic_load)
        .error(R.drawable.ic_error)
        .into(imageView)
}
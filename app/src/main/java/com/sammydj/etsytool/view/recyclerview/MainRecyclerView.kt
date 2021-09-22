package com.sammydj.etsytool.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sammydj.etsytool.R
import com.sammydj.etsytool.model.Shop
import com.sammydj.etsytool.view.recyclerview.MainViewHolder

class MainRecyclerViewAdapter: RecyclerView.Adapter<MainViewHolder>() {

    private var shopList = emptyList<Shop>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        val currentShop = shopList[position]
        holder.bind(currentShop)
    }

    override fun getItemCount(): Int {
        return shopList.size
    }

    fun updateList(list: List<Shop>) {
        shopList = list
        notifyDataSetChanged()
    }
}
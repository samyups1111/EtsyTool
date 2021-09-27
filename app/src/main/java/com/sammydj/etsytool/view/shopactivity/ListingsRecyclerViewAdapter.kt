package com.sammydj.etsytool.view.shopactivity

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sammydj.etsytool.R
import com.sammydj.etsytool.model.listing.Listing

class ListingsRecyclerViewAdapter(private val viewModel: ShopViewModel) : RecyclerView.Adapter<ListingsViewHolder>() {

    var listings = emptyList<Listing>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListingsViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.listings_item_view, parent, false)
        return ListingsViewHolder(view, viewModel)
    }

    override fun onBindViewHolder(holder: ListingsViewHolder, position: Int) {

        val currentListing = listings[position]
        holder.bind(currentListing)
        Log.d("TAG", "LRVA obvh current listing = ${currentListing.listingId}")
    }

    override fun getItemCount(): Int {
        return listings.size
    }

    fun updateList(newListingsList: List<Listing>) {
        listings = newListingsList
    }
}
package com.sammydj.etsytool.view.mainactivity.recyclerview

import android.util.Log
import android.view.View
import android.widget.AbsListView.OnScrollListener.SCROLL_STATE_IDLE
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class RecyclerViewPaginator(recyclerView: RecyclerView, val progressBar: ImageView)
    : RecyclerView.OnScrollListener() {

    private var currentPage: Int = 0 // i.e. page 1 = items 1-25 from the Network call
    private val batchSize : Int = 25
    private val threshold: Int = 5 // So you don't have to wait until the last item to start loading
    private var isFirstTimeCalled: Boolean = false // a flag to stop repeated calls to the network

    var layoutManager = recyclerView.layoutManager
    val maxSize : Int
        get() = (++currentPage) * batchSize  // Last item in the batch
    abstract val isLastPage: Boolean

    init {
        recyclerView.addOnScrollListener(this)
        this.layoutManager = recyclerView.layoutManager
    }

    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)

        if (newState == SCROLL_STATE_IDLE) {

            if (isFirstTimeCalled) {
                isFirstTimeCalled = false
            }
            val visibleItemCount = layoutManager!!.childCount
            val totalItemCount = layoutManager!!.itemCount
            val firstVisibleItem = (layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

            Log.d("TAG", "RVP visibleItemCount = $visibleItemCount")
            Log.d("TAG", "RVP totalItemCount = $totalItemCount")
            Log.d("TAG", "RVP firstvisibleItemCount = $firstVisibleItem")

            if (isLastPage) return

            if ((visibleItemCount + firstVisibleItem + threshold) >= totalItemCount) { // last item
                Log.d("TAG", "RVP endWithAuto = $isFirstTimeCalled")
                progressBar.visibility = View.VISIBLE
                Log.d("TAG", "progresbar = ${progressBar.visibility}")
                if (!isFirstTimeCalled) {
                    Log.d("TAG", "RVP maxSize = $maxSize")
                    isFirstTimeCalled = true
                    loadMore(maxSize)                           // Do another Network call
                    Log.d("TAG", "RVP loadMore")
                } else {
                    Log.d("TAG", "RVP Did NOT loadMore")
                }
            } else {
                Log.d("TAG", "RVP else")
                isFirstTimeCalled = false
            }
        }
        if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {
            isFirstTimeCalled = true
        }
    }

    abstract fun loadMore(start: Int)
}
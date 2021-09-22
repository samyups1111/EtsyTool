package com.sammydj.etsytool.view.recyclerview

import android.util.Log
import android.widget.AbsListView.OnScrollListener.SCROLL_STATE_IDLE
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class RecyclerViewPaginator(recyclerView: RecyclerView) : RecyclerView.OnScrollListener() {

    private var currentPage: Int = 0
    private val batchSize : Int = 25
    private val threshold: Int = 5
    private var endWithAuto: Boolean = false
    var layoutManager = recyclerView.layoutManager
    val startSize : Int
        get() = ++currentPage
    val maxSize : Int
        get() = (++currentPage) * batchSize
    abstract val isLastPage: Boolean

    init {
        recyclerView.addOnScrollListener(this)
        this.layoutManager = recyclerView.layoutManager
    }

    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)

        if (newState == SCROLL_STATE_IDLE) {
            val visibleItemCount = layoutManager!!.childCount
            val totalItemCount = layoutManager!!.itemCount
            val firstVisibleItem = (layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

            Log.d("TAG", "RVP visibleItemCount = $visibleItemCount")
            Log.d("TAG", "RVP totalItemCount = $totalItemCount")
            Log.d("TAG", "RVP firstvisibleItemCount = $firstVisibleItem")

            if (isLastPage) return

            if ((visibleItemCount + firstVisibleItem + threshold) >= totalItemCount) {

                if (!endWithAuto) {
                    endWithAuto = true
                    loadMore(maxSize)
                }
            } else {
                endWithAuto = false
            }
        }
    }

    fun reset() {
        currentPage = 0
    }

    abstract fun loadMore(start: Int)
}
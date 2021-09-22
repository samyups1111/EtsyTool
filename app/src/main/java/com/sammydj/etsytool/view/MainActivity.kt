package com.sammydj.etsytool.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sammydj.etsytool.MainApplication
import com.sammydj.etsytool.R
import com.sammydj.etsytool.view.recyclerview.RecyclerViewPaginator
import com.sammydj.etsytool.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var searchButton : Button
    private lateinit var recyclerView : RecyclerView
    private lateinit var deleteAllButton : Button
    private lateinit var searchEditText: EditText
    private lateinit var progressBar : ImageView
    private val viewModel : MainViewModel by lazy {
        ViewModelProvider(this, MainViewModel.MainViewModelFactory((application as MainApplication).repository)).get(MainViewModel::class.java)
    }
    private lateinit var recyclerViewAdapter : MainRecyclerViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchButton = findViewById(R.id.search_button)
        recyclerView = findViewById(R.id.recycler_view)
        deleteAllButton = findViewById(R.id.delete_all)
        searchEditText = findViewById(R.id.search_edittext)
        progressBar = findViewById(R.id.progress_bar)
        recyclerViewAdapter = MainRecyclerViewAdapter()

        setSearchButton()
        setSearchEditText()
        setDeleteButton()
        attachRecyclerViewAdapter()
        loadData()
    }

    private fun attachRecyclerViewAdapter() {

        recyclerView.apply {
            adapter = recyclerViewAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun setSearchEditText() {
        searchEditText.setOnClickListener {
            searchEditText.text.clear()
        }
    }

    private fun setSearchButton() {
        searchButton.setOnClickListener {
            val wordToSearch = searchEditText.text.toString()
            viewModel.setWordToSearch(wordToSearch)
            viewModel.clearDatabase()
            viewModel.refreshNetworkCall(viewModel.wordToSearch.value!!, 0)
            Log.d("TAG", "MA setButtons clicked")
        }
    }

    private fun loadData() {

        viewModel.list.observe(this, { shopList ->
            Log.d("TAG", "MA loadData1: shoplist.size = ${shopList.size}")

            if (shopList != null) {
                Log.d("TAG", "MA loadData2: shoplist.size = ${shopList.size}")
                recyclerViewAdapter.updateList(shopList)
                recyclerView.addOnScrollListener(object: RecyclerViewPaginator(recyclerView, progressBar) {
                    override val isLastPage: Boolean
                        get() = viewModel.isLastPage()

                    override fun loadMore(start: Int) {

                        viewModel.loadData(start)
                        Log.d("TAG", "MA loadMore: start = $start")
                        progressBar.visibility = View.INVISIBLE
                        Log.d("TAG", "progresbar = ${progressBar.visibility}")

                    }
                })
            }
        })
    }

    private fun setDeleteButton() {
        deleteAllButton.setOnClickListener {
            viewModel.clearDatabase()
            searchEditText.text.clear()
        }
    }
}
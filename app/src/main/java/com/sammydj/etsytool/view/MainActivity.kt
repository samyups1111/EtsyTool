package com.sammydj.etsytool.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sammydj.etsytool.MainApplication
import com.sammydj.etsytool.R
import com.sammydj.etsytool.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var button : Button
    private lateinit var mainTextView : TextView
    private lateinit var recyclerView : RecyclerView
    private lateinit var deleteAllButton : Button
    private val viewModel : MainViewModel by lazy {
        ViewModelProvider(this, MainViewModel.MainViewModelFactory((application as MainApplication).repository)).get(MainViewModel::class.java)
    }
    private lateinit var recyclerViewAdapter : MainRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mainTextView = findViewById(R.id.main_textview)
        button = findViewById(R.id.button)
        recyclerView = findViewById(R.id.recycler_view)
        deleteAllButton = findViewById(R.id.delete_all)
        recyclerViewAdapter = MainRecyclerViewAdapter()

        setButtons()
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

    private fun setButtons() {
        button.setOnClickListener {
            viewModel.refreshNetworkCall()
            Log.d("TAG", "MA setButtons clicked")
        }

    }

    private fun loadData() {

        viewModel.list.observe(this, { shopList ->

            if (shopList != null) {
                recyclerViewAdapter.updateList(shopList)
                Log.d("TAG", "MA shopList.size = ${shopList.size}")
            }

        })
    }

    private fun setDeleteButton() {
        deleteAllButton.setOnClickListener {
            viewModel.clearDatabase()
        }
    }
}
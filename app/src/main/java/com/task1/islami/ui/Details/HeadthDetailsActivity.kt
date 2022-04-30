package com.task1.islami.ui.Details

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.task1.islami.R
import com.task1.islami.ui.Constants.Constants
import com.task1.islami.ui.adapters.HeadthDetailsAdapter


class HeadthDetailsActivity : AppCompatActivity() {

    lateinit var headthNumber: TextView
    lateinit var headthDetailsRecyclerView: RecyclerView
    lateinit var headthDetailsAdapter: HeadthDetailsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_headth_details)
        headthNumber = findViewById(R.id.NumberOfHeadth)

        backButton()
        init_Recycler_View()

        //Read Data From Intent
        var headthName: String = intent.getStringExtra(Constants.HEADTH_NUMBER) ?: ""
        var headthPosition: Int = intent.getIntExtra(Constants.HEADTH_POSITION, 0)
        headthNumber.setText(headthName)
        readHeadthFile(headthPosition)

    }

    private fun readHeadthFile(position: Int) {

        var fileName: String = "HeadthFiles/h${position + 1}.txt"
        var headth: String = assets.open(fileName).bufferedReader().use { it.readText() }
        var headthContent: List<String> = headth.split("\n")
        headthDetailsAdapter.reloadHeadthAdapter(headthContent)

    }

    fun init_Recycler_View() {
        headthDetailsRecyclerView = findViewById(R.id.Headth_Details_Recycler_View)
        headthDetailsAdapter = HeadthDetailsAdapter()
        headthDetailsRecyclerView.adapter = headthDetailsAdapter
    }

    fun backButton() {
        setSupportActionBar(findViewById(R.id.toolbar1))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

}
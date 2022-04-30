package com.task1.islami.ui.Details

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.task1.islami.R
import com.task1.islami.ui.Constants.Constants
import com.task1.islami.ui.adapters.SuraDetailsAdapter


class SuraDetailsActivity : AppCompatActivity() {

    lateinit var titleOfSura: TextView
    lateinit var suraDetailsAdapter: SuraDetailsAdapter
    lateinit var suraDetailsRecyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)
        titleOfSura = findViewById(R.id.Title_Of_Sura)

        backButton()
        initRecyclerView()

        //Read Data From Intent
        var suraName: String = intent.getStringExtra(Constants.SURA_NAME) ?: ""
        var suraPosition: Int = intent.getIntExtra(Constants.SURA_POSITION, 0)
        titleOfSura.setText(" سورة" + suraName)
        readSuraFile(suraPosition)


    }

    fun initRecyclerView() {
        suraDetailsRecyclerView = findViewById(R.id.Sura_Details_Recycler_View)
        suraDetailsAdapter = SuraDetailsAdapter()
        suraDetailsRecyclerView.adapter = suraDetailsAdapter
    }

    fun readSuraFile(position: Int) {

        var fileName: String = "QuranFiles/${position + 1}.txt"
        var contentOfSura = assets.open(fileName).bufferedReader().use { it.readText() }
        var verses: List<String> = contentOfSura.split("\n")
        suraDetailsAdapter.reloadAdapter(verses)

    }

    fun backButton() {
        setSupportActionBar(findViewById(R.id.toolbar2))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}



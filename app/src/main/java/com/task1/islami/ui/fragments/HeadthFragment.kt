package com.task1.islami.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.task1.islami.R
import com.task1.islami.ui.Constants.Constants
import com.task1.islami.ui.Details.HeadthDetailsActivity
import com.task1.islami.ui.adapters.HeadthAdapter

class HeadthFragment : Fragment() {
    lateinit var headthList: MutableList<String>
    lateinit var headthRecyclerView: RecyclerView
    lateinit var headthAdapter: HeadthAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.headth_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        headthRecyclerView = view.findViewById(R.id.headth_Recycler_View)
        createHeadthList()
        headthAdapter = HeadthAdapter(headthList)
        headthAdapter.onHeadthClickListener = object : HeadthAdapter.OnItemClickListener {
            override fun onItemClick(position: Int, headthName: String) {

                var intent: Intent = Intent(context, HeadthDetailsActivity::class.java)
                intent.putExtra(Constants.HEADTH_NUMBER, headthName)
                intent.putExtra(Constants.HEADTH_POSITION, position)
                startActivity(intent)
            }

        }
        headthRecyclerView.adapter = headthAdapter
    }

    private fun createHeadthList() {

        headthList = mutableListOf()

        for (i in 1..50) {

            headthList.add("الحديث رقم  " + i)
        }
    }
}
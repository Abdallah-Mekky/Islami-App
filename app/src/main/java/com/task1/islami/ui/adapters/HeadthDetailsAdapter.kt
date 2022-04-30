package com.task1.islami.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.task1.islami.R

class HeadthDetailsAdapter : RecyclerView.Adapter<HeadthDetailsAdapter.HeadthDetailsViewHolder>() {

    var contentOfHeadth: List<String>? = null

    class HeadthDetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var contentofHeadth: TextView = itemView.findViewById(R.id.headthContent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadthDetailsViewHolder {

        var view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.headth_details_item, parent, false)

        return HeadthDetailsViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeadthDetailsViewHolder, position: Int) {

        var headthCotent: String? = contentOfHeadth?.get(position)
        holder.contentofHeadth.setText(headthCotent)

    }

    override fun getItemCount(): Int {

        return contentOfHeadth?.size ?: 0
    }

    fun reloadHeadthAdapter(contentOfHeadth: List<String>) {
        this.contentOfHeadth = contentOfHeadth
        notifyDataSetChanged()
    }


}
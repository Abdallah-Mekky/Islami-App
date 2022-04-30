package com.task1.islami.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.task1.islami.R

class HeadthAdapter(var headthList: List<String>) :
    RecyclerView.Adapter<HeadthAdapter.HeadthViewHolder>() {

    class HeadthViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var headthNumber: TextView = itemView.findViewById(R.id.chapter_Name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadthViewHolder {
        var view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.quran_item, parent, false)

        return HeadthViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeadthViewHolder, position: Int) {

        var listItems: String = headthList[position]

        holder.headthNumber.setText(listItems)

        if (onHeadthClickListener != null)
            holder.itemView.setOnClickListener {
                onHeadthClickListener?.onItemClick(position, listItems)
            }
    }

    override fun getItemCount(): Int {
        return headthList.size
    }

    var onHeadthClickListener: OnItemClickListener? = null

    interface OnItemClickListener {

        fun onItemClick(position: Int, headthName: String)
    }
}
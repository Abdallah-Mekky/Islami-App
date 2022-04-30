package com.task1.islami.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.task1.islami.R

class SuraAdapter(var suraList: List<String>) : RecyclerView.Adapter<SuraAdapter.SuraViewHolder>() {

    class SuraViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var suraName: TextView = itemView.findViewById(R.id.chapter_Name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuraViewHolder {
        var view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.quran_item, parent, false)

        return SuraViewHolder(view)
    }

    override fun onBindViewHolder(holder: SuraViewHolder, position: Int) {

        var listItems: String = suraList[position]

        holder.suraName.setText(listItems)

        if (onSuraClickListener != null)
            holder.itemView.setOnClickListener {
                onSuraClickListener?.onItemClick(position, listItems)
            }


    }

    override fun getItemCount(): Int {
        return suraList.size
    }


    var onSuraClickListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(position: Int, suraName: String)
    }
}
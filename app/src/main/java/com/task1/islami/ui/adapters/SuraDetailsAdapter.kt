package com.task1.islami.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.task1.islami.R

class SuraDetailsAdapter : RecyclerView.Adapter<SuraDetailsAdapter.SuraDetailsViewHolder>() {

    var listofVerces: List<String>? = null

    class SuraDetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var suraDetails: TextView = itemView.findViewById(R.id.sura_Details_Name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuraDetailsViewHolder {

        var view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.sura_details_item, parent, false)
        return SuraDetailsViewHolder(view)
    }


    override fun onBindViewHolder(holder: SuraDetailsViewHolder, position: Int) {

        var versesOfSura: String? = listofVerces?.get(position)
        holder.suraDetails.setText(versesOfSura)
    }

    override fun getItemCount(): Int {

        return listofVerces?.size ?: 0
    }


    fun reloadAdapter(versesOfSura: List<String>) {

        this.listofVerces = versesOfSura
        notifyDataSetChanged()
    }
}
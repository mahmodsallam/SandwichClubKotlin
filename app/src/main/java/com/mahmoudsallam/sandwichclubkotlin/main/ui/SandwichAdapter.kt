package com.mahmoudsallam.sandwichclubkotlin.main.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mahmoudsallam.sandwichclubkotlin.R

class SandwichAdapter
    (
    var context: Context,
    var sandwichsList: Array<String>,
    var detailsInterface: DetailsInterface
) : RecyclerView.Adapter<SandwichAdapter.SandwichViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SandwichViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.sandwich_row, parent, false)
        return SandwichViewHolder(view)
    }

    override fun getItemCount(): Int {
        return sandwichsList.count()
    }

    override fun onBindViewHolder(holder: SandwichViewHolder, position: Int) {
        holder.sandwichName.text = sandwichsList[position]
        holder.itemView.setOnClickListener { detailsInterface.openDetails(sandwichsList[position]) }
    }

    class SandwichViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var sandwichName: TextView = itemView.findViewById(R.id.sandwichName_tv)
    }
}
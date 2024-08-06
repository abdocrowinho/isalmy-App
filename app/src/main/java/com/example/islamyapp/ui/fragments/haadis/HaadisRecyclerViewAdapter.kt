package com.example.islamyapp.ui.fragments.haadis

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamyapp.databinding.ContetntHaadisBinding

class HaadisRecyclerViewAdapter(val ListOfHaadises: List<HaadisModel>) :
    RecyclerView.Adapter<HaadisRecyclerViewAdapter.ViewHolder>() {
    class ViewHolder(val binding: ContetntHaadisBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ContetntHaadisBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int =
        ListOfHaadises.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val haadis = ListOfHaadises[position]
        holder.binding.contentHaadis.text = haadis.tittle
        holder.binding.root.setOnClickListener {
            setOnItemClickListener!!.onClickListener(haadis, position)
        }
    }

    fun interface OnClick {
        fun onClickListener(haadis: HaadisModel, position: Int)
    }

    var setOnItemClickListener: OnClick? = null
}
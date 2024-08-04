package com.example.islamyapp.ui.fragments.quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamyapp.R
import com.example.islamyapp.databinding.QuranVersesBinding

class QuranRecyclerViewAdapter(val  chapters : List<String>) : RecyclerView.Adapter<QuranRecyclerViewAdapter.ViewHolder>() {
var onItemClick : OnClick?=null

    class ViewHolder(val binding : QuranVersesBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = QuranVersesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return chapters.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val chapter = chapters[position]
        holder.binding.tvQuranVerses.text = "$chapter"
        holder.binding.root.setOnClickListener() {
            onItemClick?.onItemClick(position, chapter)
        }
    }

    fun  interface OnClick{
        fun onItemClick(position : Int , tittle : String)
    }

}
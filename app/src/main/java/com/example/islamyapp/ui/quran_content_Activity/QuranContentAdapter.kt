package com.example.islamyapp.ui.quran_content_Activity

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamyapp.R

class QuranContentAdapter(private val verses:List<String>) : RecyclerView.Adapter<QuranContentAdapter.ViewHolder>() {
    class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val quranVerses : TextView = itemView.findViewById(R.id.tv_quranVerses)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
     val view : View = LayoutInflater.from(parent.context)
         .inflate(R.layout.quran_verses,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return verses.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lineOfSourah : String = verses[position]
        holder.quranVerses.text =
                 lineOfSourah + "(${position+1})"

    }
}
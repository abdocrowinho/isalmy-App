package com.example.islamyapp.ui.quran_content_Activity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.islamyapp.R
import com.example.islamyapp.databinding.ActivityQuranBinding

class quran_activity : AppCompatActivity() {
    lateinit var binding:ActivityQuranBinding
    lateinit var verses : List<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuranBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
        setAdapter()
        isFatiha()

    }

    private fun isFatiha() {
        val position = intent.getIntExtra(POSITION,-1)
        if (position==0){
            binding.RvQuranVerses.bsmallhText.text=null
        }
    }


    private fun initViews() {
        val  title = intent.getStringExtra(TITTLE)
        val position = intent.getIntExtra(POSITION , -1)
        binding.tittleSourah.text = title
        initList(position)




    }

    private fun initList(position:Int) {
      val sourah  =  assets.open("${position+1}.txt").bufferedReader().use {it.readText()}
        val listOfversrs = sourah.split("\n")
        verses = listOfversrs

    }

    private fun setAdapter() {
   val  adapter :  QuranContentAdapter = QuranContentAdapter(verses)
        binding.RvQuranVerses.RvQuranVerses.adapter = adapter
    }


    companion object {
     const   val  TITTLE : String = "tittle"
      const  val  POSITION : String = "position"
    }
}
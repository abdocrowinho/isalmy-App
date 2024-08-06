package com.example.islamyapp.ui.fragments.haadis

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.islamyapp.databinding.ActivityHaadisBinding
import com.example.islamyapp.ui.Constants

class HaadisActivity : AppCompatActivity() {
    lateinit var binding: ActivityHaadisBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHaadisBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val haadis = intent.getParcelableExtra<HaadisModel>(Constants.haadis)
        initViews(haadis!!)
    }

    private fun initViews(haadis: HaadisModel) {
        binding.IncludeHaadisVerses.haadisText.text = haadis.content
        binding.tittleHaadis.text = haadis.tittle
    }
}
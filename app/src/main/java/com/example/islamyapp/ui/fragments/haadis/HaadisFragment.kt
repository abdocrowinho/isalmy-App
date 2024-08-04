package com.example.islamyapp.ui.fragments.haadis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamyapp.R
import com.example.islamyapp.databinding.FragmentHaadisBinding

class HaadisFragment : Fragment() {
    lateinit var binding: FragmentHaadisBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHaadisBinding.inflate(inflater,container,false)
     return  binding.root
    }
}
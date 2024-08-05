package com.example.islamyapp.ui.fragments.haadis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamyapp.databinding.FragmentHaadisBinding

class HaadisFragment : Fragment() {
    lateinit var binding: FragmentHaadisBinding
    val listOfTittles = mutableListOf<HaadisModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHaadisBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        readHaadis()
        bindHaadisList()

    }

    private fun bindHaadisList() {
        val adapter = HaadisRecyclerViewAdapter(listOfTittles)
        binding.RvHaadis.adapter = adapter
    }

    private fun readHaadis() {
        val listOfNamesHaadis = mutableListOf<HaadisModel>()
        val listOfHaadis = requireContext().assets.open("ahadeth.txt")
            .bufferedReader().use { it.readText() }

        val speratedAhadeathContent = listOfHaadis.split("#")

        speratedAhadeathContent.forEach { haadis ->
            val linesOfHaadis = haadis.trim().split("\n").toMutableList()
            val title = linesOfHaadis[0]
            linesOfHaadis.removeAt(0)
            val haadiis = HaadisModel(
                title, linesOfHaadis.joinToString("\n")
            )
            listOfTittles.add(haadiis)
        }


    }

}

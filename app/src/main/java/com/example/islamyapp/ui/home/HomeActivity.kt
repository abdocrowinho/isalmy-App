package com.example.islamyapp.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.islamyapp.R
import com.example.islamyapp.ui.fragments.haadis.HaadisFragment
import com.example.islamyapp.ui.fragments.quran.QuranFragment
import com.example.islamyapp.ui.fragments.radio.RadioFragment
import com.example.islamyapp.ui.fragments.tsaabih.TsaabihFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    lateinit var bottomNav: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initViews()
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_fragment, fragment).commit()


    }

    private fun initViews() {
        bottomNav = findViewById(R.id.bottomNavBar)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.tsabeh -> {
                    showFragment(TsaabihFragment())

                }

                R.id.hadis -> {
                    showFragment(HaadisFragment())
                }

                R.id.quran -> {
                    showFragment(QuranFragment())
                }

                R.id.radio -> {
                    showFragment(RadioFragment())
                }
            }

            return@setOnItemSelectedListener true
        }
        bottomNav.selectedItemId = R.id.radio
    }
}
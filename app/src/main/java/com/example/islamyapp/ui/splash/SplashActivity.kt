package com.example.islamyapp.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.islamyapp.R
import com.example.islamyapp.ui.home.HomeActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
      Handler(Looper.getMainLooper()).postDelayed({
          startHomeActivity()
      },
      2000)
    }

    private fun startHomeActivity() {
        var  intent = Intent(this , HomeActivity::class.java)
        startActivity(intent)
        finish()
    }



}
package com.task1.islami.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.task1.islami.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        splash()
    }

    fun moveToHome() {

        var intent: Intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun splash() {

        Handler(Looper.getMainLooper()).postDelayed(Runnable { moveToHome() }, 2000)
    }
}
package com.alphitardian.moviecatalogueapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.alphitardian.moviecatalogueapplication.R
import com.alphitardian.moviecatalogueapplication.ui.main.MainActivity
import com.alphitardian.moviecatalogueapplication.utils.EspressoIdlidngResource

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()

        EspressoIdlidngResource.increment()
        Handler().postDelayed(Runnable {
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
            EspressoIdlidngResource.decrement()
        }, 2000)
    }
}
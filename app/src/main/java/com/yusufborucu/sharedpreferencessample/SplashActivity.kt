package com.yusufborucu.sharedpreferencessample

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    private var handler: Handler? = null
    private var delay: Long = 3000

    private val runnable: Runnable = Runnable {
        if (!isFinishing) {
            val preferences = getSharedPreferences("MyApp", Context.MODE_PRIVATE)
            if (preferences.getBoolean("login", false)) {
                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(applicationContext, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        handler = Handler()
        handler!!.postDelayed(runnable, delay)
    }

    override fun onDestroy() {
        if (handler != null) {
            handler!!.removeCallbacks(runnable)
        }
        super.onDestroy()
    }

}

package com.yusufborucu.sharedpreferencessample

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bLogout.setOnClickListener {
            val preferences = getSharedPreferences("MyApp", Context.MODE_PRIVATE)
            val editor = preferences.edit()
            editor.putBoolean("login", false)
            editor.apply()

            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

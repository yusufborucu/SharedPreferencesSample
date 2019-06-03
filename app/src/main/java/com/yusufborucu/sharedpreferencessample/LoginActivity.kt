package com.yusufborucu.sharedpreferencessample

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        bLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            if (username == "aliveli" && password == "123456") {
                val preferences = getSharedPreferences("MyApp", Context.MODE_PRIVATE)
                val editor = preferences.edit()
                editor.putBoolean("login", true)
                editor.apply()

                val intent = Intent(applicationContext, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Kullanıcı adı veya parola yanlış.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

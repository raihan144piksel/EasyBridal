package com.example.easybridal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class LoginMenu : AppCompatActivity() {

    private lateinit var daftar: TextView
    private lateinit var logintombol: Button

    private fun initComponents(){
        daftar = findViewById(R.id.daftar)
        logintombol = findViewById(R.id.logintombol)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_loginmenu)

        initComponents()

        daftar.setOnClickListener {
            val intent = Intent(this@LoginMenu, SignUpMenu::class.java)
            startActivity(intent)
        }

        logintombol.setOnClickListener{
            val intent = Intent(this@LoginMenu, HomeMenu::class.java)
            startActivity(intent)
        }

    }
}

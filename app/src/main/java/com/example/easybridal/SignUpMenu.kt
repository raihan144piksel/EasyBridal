package com.example.easybridal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SignUpMenu : AppCompatActivity() {

    private lateinit var daftartombol: Button

    private fun initcomponents(){
        daftartombol = findViewById(R.id.daftartombol)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signupmenu)

        initcomponents()

        daftartombol.setOnClickListener {
            val intent = Intent(this@SignUpMenu, LoginMenu::class.java)
            startActivity(intent)
        }

    }
}
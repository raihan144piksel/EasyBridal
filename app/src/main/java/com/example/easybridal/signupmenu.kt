package com.example.easybridal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class signupmenu : AppCompatActivity() {

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
            val intent = Intent(this@signupmenu, loginmenu::class.java)
            startActivity(intent)
        }

    }
}
package com.example.easybridal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PaymentSuccess : AppCompatActivity() {

    private lateinit var tombolselesai: Button

    private fun initComponents() {
        tombolselesai = findViewById(R.id.tombolcekorder)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_payment_success)

        initComponents()

        tombolselesai.setOnClickListener {
            // Start PaymentSuccess activity
            val intent = Intent(this@PaymentSuccess, HomeMenu::class.java)
            startActivity(intent)
        }

    }
}
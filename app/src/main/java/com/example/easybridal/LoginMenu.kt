package com.example.easybridal

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class LoginMenu : AppCompatActivity() {

    private lateinit var daftar: TextView
    private lateinit var logintombol: Button
    private lateinit var emailField: EditText
    private lateinit var passwordField: EditText

    private fun initComponents() {
        daftar = findViewById(R.id.daftar)
        logintombol = findViewById(R.id.logintombol)
        emailField = findViewById(R.id.email_field)
        passwordField = findViewById(R.id.password_field)
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

        logintombol.setOnClickListener {
            val email = emailField.text.toString()
            val password = passwordField.text.toString()

            if (validateLogin(email, password)) {
                // Navigate to the home screen
                val intent = Intent(this@LoginMenu, HomeMenu::class.java)
                startActivity(intent)
            }
        }
    }

    private fun validateLogin(email: String, password: String): Boolean {
        val customer = PusatData.getCustomerByEmailAndPassword(email, password)
        return if (customer != null) {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
            true
        } else {
            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            false
        }
    }
}

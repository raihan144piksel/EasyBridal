package com.example.easybridal

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SignUpMenu : AppCompatActivity() {

    private lateinit var daftartombol: Button
    private lateinit var emailField: EditText
    private lateinit var passwordField: EditText
    private lateinit var repasswordField: EditText

    private fun initComponents() {
        daftartombol = findViewById(R.id.daftartombol)
        emailField = findViewById(R.id.email_field)
        passwordField = findViewById(R.id.password_field)
        repasswordField = findViewById(R.id.repassword_field)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signupmenu)

        initComponents()

        daftartombol.setOnClickListener {
            val email = emailField.text.toString()
            val password = passwordField.text.toString()
            val repeatPassword = repasswordField.text.toString()

            if (validateInput(email, password, repeatPassword)) {
                // Create Customer object
                val customer = Customer(
                    id = PusatData.getNextCustomerId(), // Use a function to generate a new ID
                    email = email,
                    password = password,
                    name = "", // You can collect and set other fields later
                    photoProfile = "",
                    phoneNumber = "",
                    cardHolderName = "",
                    cardNumber = "",
                    expiryDate = "",
                    securityCode = "",
                    postalCode = "",
                    country = "",
                    cartItems = listOf(),
                    groomFirstName = "",
                    groomSurname = "",
                    brideFirstName = "",
                    brideSurname = "",
                    homeLocation = "",
                    weddingLocation = "",
                    weddingDate = "",
                    checkoutHistory = listOf()
                )

                // Add customer to PusatData
                PusatData.addCustomer(customer)

                // Navigate to LoginMenu
                val intent = Intent(this, LoginMenu::class.java)
                startActivity(intent)
            }
        }
    }

    private fun validateInput(email: String, password: String, repeatPassword: String): Boolean {
        if (email.isEmpty() || password.isEmpty() || repeatPassword.isEmpty()) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
            return false
        }
        if (password != repeatPassword) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            return false
        }
        // Add more validation logic if needed
        return true
    }
}

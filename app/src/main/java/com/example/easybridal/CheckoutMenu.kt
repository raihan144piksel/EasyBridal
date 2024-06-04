package com.example.easybridal

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.easybridal.databinding.ActivityCheckoutMenuBinding

class CheckoutMenu : AppCompatActivity() {

    private lateinit var binding: ActivityCheckoutMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCheckoutMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val totalPrice = intent.getStringExtra("TOTAL_PRICE")
        binding.totalharga.text = totalPrice


        val customerEmail = intent.getStringExtra("CUSTOMER_EMAIL")
        // Load customer data based on the email or any other unique identifier
        val customer = PusatData.getCustomerByEmail(customerEmail ?: "")
        if (customer != null) {
            // Populate the fields with customer data
            binding.kolomfirstnamegroom.setText(customer.groomFirstName)
            binding.kolomsurnamegroom.setText(customer.groomSurname)
            binding.kolomfirstnamebride.setText(customer.brideFirstName)
            binding.kolomsurnamebride.setText(customer.brideSurname)
            binding.kolomhomelocation.setText(customer.homeLocation)
            binding.kolomweddinglocation.setText(customer.weddingLocation)
            // Split the wedding date into year, month, and day if needed
            val weddingDate = customer.weddingDate.split("-")
            if (weddingDate.size == 3) {
                binding.kolomtahun.setText(weddingDate[0])
                binding.kolombulan.setText(weddingDate[1])
                binding.kolomtanggal.setText(weddingDate[2])
            }
            binding.namakartu.setText(customer.cardHolderName)
            binding.nomorkartu.setText(customer.cardNumber)
            binding.tanggalexpire.setText(customer.expiryDate)
            binding.kodesecurity.setText(customer.securityCode)
            binding.kodepost.setText(customer.postalCode)
            binding.negara.setText(customer.country)

        }
        binding.tombolorder.setOnClickListener {
            // Launch PaymentSucces activity
            startActivity(Intent(this, PaymentSuccess::class.java))
        }

    }
}

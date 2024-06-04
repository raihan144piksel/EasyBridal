package com.example.easybridal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.easybridal.databinding.ActivityCartMenuBinding
import java.text.NumberFormat
import java.util.Locale

class CartMenu : AppCompatActivity() {

    private lateinit var binding: ActivityCartMenuBinding
    private lateinit var adapter: CartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cartItems = CartManager.getItems()
        adapter = CartAdapter(cartItems)

        binding.rvCart.layoutManager = LinearLayoutManager(this)
        binding.rvCart.adapter = adapter

        // Update total price initially
        updateTotalPrice()

        binding.removeall.setOnClickListener {
            CartManager.clearItems()
            adapter.notifyDataSetChanged()
            updateTotalPrice()
        }

        binding.cekot.setOnClickListener {
            val totalPrice = adapter.getTotalPrice()
            val formattedPrice = NumberFormat.getNumberInstance(Locale.US).format(totalPrice.toInt())

            val intent = Intent(this, CheckoutMenu::class.java).apply {
                putExtra("TOTAL_PRICE", "Rp$formattedPrice")
            }
            startActivity(intent)
        }
    }

    private fun updateTotalPrice() {
        val totalPrice = adapter.getTotalPrice()
        val formattedPrice = NumberFormat.getNumberInstance(Locale.US).format(totalPrice.toInt())
        binding.totalharga.text = "Rp$formattedPrice"
    }
}

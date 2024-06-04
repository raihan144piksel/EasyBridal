package com.example.easybridal

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.easybridal.databinding.ActivityDetailServiceBinding
import java.text.DecimalFormat

class DetailService : AppCompatActivity() {

    private lateinit var binding: ActivityDetailServiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra("title")
        val price = intent.getDoubleExtra("price", 0.0)
        val description = intent.getStringExtra("description")
        val vendor = intent.getStringExtra("vendor")
        val pictures = intent.getIntegerArrayListExtra("pictures")

        binding.judulservice.text = title
        binding.totalharga.text = "Rp${formatPriceWithDots(price.toInt())}"
        binding.deskripsi.text = description
        binding.namavendor.text = vendor
        if (pictures != null && pictures.isNotEmpty()) {
            binding.gambarjasa.setImageResource(pictures[0]) // Display the first picture
        }

        binding.balonchat.setOnClickListener {
            val intent = Intent(this, ChatMenu::class.java).apply {
                putExtra("vendor", vendor)
            }
            startActivity(intent)
        }
        binding.namavendor.setOnClickListener {
            val intent = Intent(this, ProviderAccount::class.java).apply {
                putExtra("serviceProviderName", binding.namavendor.text.toString())
                putExtra("username", binding.namavendor.text.toString())
            }
            startActivity(intent)
        }

        binding.cekot.setOnClickListener {
            val item = CartItem(pictures?.get(0) ?: 0, vendor ?: "", price, title?: "")
            CartManager.addItem(item)
            Toast.makeText(this, "Item added to cart", Toast.LENGTH_SHORT).show()
        }
    }

    private fun formatPriceWithDots(price: Int): String {
        val decimalFormat = DecimalFormat("#,###")
        decimalFormat.isGroupingUsed = true
        decimalFormat.groupingSize = 3
        return decimalFormat.format(price).replace(",", ".")
    }

}

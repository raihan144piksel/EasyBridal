package com.example.easybridal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.easybridal.databinding.ActivityProviderAccountBinding

class ProviderAccount : AppCompatActivity(), AdapterProviderAccount.OnItemClickListener {

    private lateinit var binding: ActivityProviderAccountBinding
    private lateinit var adapter: AdapterProviderAccount

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProviderAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val serviceProviderName = intent.getStringExtra("serviceProviderName")
        val username = intent.getStringExtra("username")

        if (serviceProviderName != null) {
            val serviceProvider = PusatData.serviceProviders.find { it.name == serviceProviderName }
            val products = PusatData.getProductsByServiceProvider(serviceProviderName)

            if (serviceProvider != null) {
                setupRecyclerView(serviceProvider, products)
                binding.namavendor.text = serviceProviderName
                binding.idusername.text = username
                binding.pp.setImageResource(serviceProvider.photoProfile)
                binding.deskripsi.text = serviceProvider.description
            }
        }
        // Set OnClickListener for the ImageView
        binding.chat.setOnClickListener {
            val intent = Intent(this, ChatMenu::class.java).apply {
                putExtra("vendor", serviceProviderName)
            }
            startActivity(intent)
        }
    }

    private fun setupRecyclerView(serviceProvider: ServiceProvider, products: List<Product>) {
        adapter = AdapterProviderAccount(serviceProvider, products, this)
        binding.viewpagertab.layoutManager = GridLayoutManager(this, 2)
        binding.viewpagertab.adapter = adapter
    }

    override fun onItemClick(position: Int) {
        val selectedProduct = adapter.products[position]
        val intent = Intent(this, DetailService::class.java).apply {
            putExtra("title", selectedProduct.title)
            putExtra("price", selectedProduct.price)
            putExtra("description", selectedProduct.description)
            putExtra("vendor", selectedProduct.vendor)
            putIntegerArrayListExtra("pictures", ArrayList(selectedProduct.pictures))
        }
        startActivity(intent)
    }
}

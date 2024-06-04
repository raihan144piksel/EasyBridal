package com.example.easybridal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.easybridal.databinding.ActivityChatMenuBinding

class ChatMenu : AppCompatActivity() {

    private lateinit var binding: ActivityChatMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve the vendor name from the intent
        val vendorName = intent.getStringExtra("vendor")

        // Find the corresponding ServiceProvider
        val serviceProvider = PusatData.serviceProviders.find { it.name == vendorName }

        // Display the ServiceProvider data
        if (serviceProvider != null) {
            binding.namavendor.text = serviceProvider.name
            binding.pp.setImageResource(serviceProvider.photoProfile)
        } else {
            // Handle the case where the ServiceProvider is not found
            binding.namavendor.text = "Service Provider not found"
        }
    }
}

package com.example.easybridal

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.easybridal.databinding.RawVendorBinding
import java.text.DecimalFormat

class VendorAdapter(private val vendorList: List<Product>, private val fragment: Fragment) :
    RecyclerView.Adapter<VendorAdapter.VendorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VendorViewHolder {
        val binding = RawVendorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VendorViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VendorViewHolder, position: Int) {
        holder.bind(vendorList[position], fragment)
    }

    override fun getItemCount() = vendorList.size

    class VendorViewHolder(private val binding: RawVendorBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Product, fragment: Fragment) {
            binding.fotovendor1.setImageResource(data.pictures[0]) // Use the first picture as the main image
            binding.titleproduct.text = data.title
            binding.namavendor.text = data.vendor
            binding.hargaproduct.text = "Rp${formatPriceWithDots(data.price.toInt())}" // Assuming price is in Rupiah and converting to string
            binding.lokasi.text = data.lokasi

            // Set OnClickListener on the CardView
            binding.root.setOnClickListener {
                val context = fragment.requireContext()
                val intent = Intent(context, DetailService::class.java).apply {
                    putExtra("title", data.title)
                    putExtra("price", data.price)
                    putExtra("description", data.description)
                    putExtra("vendor", data.vendor)
                    putIntegerArrayListExtra("pictures", ArrayList(data.pictures))
                }
                context.startActivity(intent)
            }
        }
        private fun formatPriceWithDots(price: Int): String {
            val decimalFormat = DecimalFormat("#,###")
            decimalFormat.isGroupingUsed = true
            decimalFormat.groupingSize = 3
            return decimalFormat.format(price).replace(",", ".")
        }

    }


}

package com.example.easybridal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.easybridal.databinding.RawVendorBinding
import java.text.DecimalFormat

class AdapterProviderAccount(
    private val serviceProvider: ServiceProvider,
    val products: List<Product>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<AdapterProviderAccount.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    inner class ViewHolder(private val binding: RawVendorBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        fun bind(product: Product) {
            binding.fotovendor1.setImageResource(product.pictures.first())
            binding.titleproduct.text = product.title
            binding.namavendor.text = product.vendor
            binding.hargaproduct.text = "Rp${formatPriceWithDots(product.price.toInt())}"
            binding.root.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RawVendorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(products[position])
    }

    override fun getItemCount(): Int = products.size

    private fun formatPriceWithDots(price: Int): String {
        val decimalFormat = DecimalFormat("#,###")
        decimalFormat.isGroupingUsed = true
        decimalFormat.groupingSize = 3
        return decimalFormat.format(price).replace(",", ".")
    }
}

package com.example.easybridal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.easybridal.databinding.RawCartBinding

data class CartItem(val image: Int, val vendorName: String, val price: Double, val productName: String)

class CartAdapter(private val cartItems: List<CartItem>) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    inner class CartViewHolder(val binding: RawCartBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = RawCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val item = cartItems[position]
        holder.binding.gambarjasa.setImageResource(item.image)
        holder.binding.namavendor.text = item.vendorName
        holder.binding.hargaproduct.text = "Rp${item.price.toInt()}"
        holder.binding.namajasa.text = item.productName
    }

    override fun getItemCount(): Int = cartItems.size

    fun getTotalPrice(): Double {
        return cartItems.sumOf { it.price }
    }
}

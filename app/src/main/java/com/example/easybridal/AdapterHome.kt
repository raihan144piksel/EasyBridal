package com.example.easybridal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import java.text.DecimalFormat

class AdapterHome(
    private val productList: List<Product>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<AdapterHome.HomeViewHolder>() {

    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val productImage: ShapeableImageView = itemView.findViewById(R.id.fotovendor1)
        val productName: TextView = itemView.findViewById(R.id.titleproduct)
        val productVendor: TextView = itemView.findViewById(R.id.namavendor)
        val productPrice: TextView = itemView.findViewById(R.id.hargaproduct)
        val lokasi: TextView = itemView.findViewById(R.id.lokasi)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.raw_vendor, parent, false)
        return HomeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val currentItem = productList[position]
        holder.productImage.setImageResource(currentItem.pictures[0])
        holder.productName.text = currentItem.title
        holder.productVendor.text = currentItem.vendor
        holder.productPrice.text = "Rp${formatPriceWithDots(currentItem.price.toInt())}"
        holder.lokasi.text = currentItem.lokasi
    }

    override fun getItemCount() = productList.size

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    private fun formatPriceWithDots(price: Int): String {
        val decimalFormat = DecimalFormat("#,###")
        decimalFormat.isGroupingUsed = true
        decimalFormat.groupingSize = 3
        return decimalFormat.format(price).replace(",", ".")
    }

}

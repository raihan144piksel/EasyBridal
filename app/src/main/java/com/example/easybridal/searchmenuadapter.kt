package com.example.easybridal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.easybridal.databinding.RvFeedSearchBinding
import com.example.easybridal.databinding.RvVendorSearchBinding

class FeedAdapter(private val feedList: List<FeedData>) :
    RecyclerView.Adapter<FeedAdapter.FeedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val binding = RvFeedSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FeedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.bind(feedList[position])
    }

    override fun getItemCount() = feedList.size

    class FeedViewHolder(private val binding: RvFeedSearchBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: FeedData) {
            binding.fotofeed1.setImageResource(data.imageResId)
        }
    }
}

class VendorAdapter(private val vendorList: List<VendorData>) :
    RecyclerView.Adapter<VendorAdapter.VendorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VendorViewHolder {
        val binding = RvVendorSearchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VendorViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VendorViewHolder, position: Int) {
        holder.bind(vendorList[position])
    }

    override fun getItemCount() = vendorList.size

    class VendorViewHolder(private val binding: RvVendorSearchBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: VendorData) {
            binding.fotovendor1.setImageResource(data.imageResId)
            binding.titleproduct.text = data.title
            binding.namavendor.text = data.vendorName
            binding.hargaproduct.text = data.price
        }
    }
}

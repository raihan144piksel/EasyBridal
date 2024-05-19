package com.example.easybridal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.recyclerview.widget.RecyclerView
import com.example.easybridal.databinding.RecyclerViewOrderhistoryBinding

data class DataOrderHistory(
    val imageResId: Int,
    val name: String,
    val date: String,
    val status: String
) {
    @get:ColorRes
    val statusColor: Int
        get() = when (status) {
            "Completed" -> R.color.ijokomplit
            "Booked" -> R.color.kuningbooked
            "Cancelled" -> R.color.merahcancel
            else -> R.color.black
        }
}

class OrderHistoryAdapter(private val orderList: List<DataOrderHistory>) :
    RecyclerView.Adapter<OrderHistoryAdapter.OrderHistoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderHistoryViewHolder {
        val binding = RecyclerViewOrderhistoryBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return OrderHistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrderHistoryViewHolder, position: Int) {
        val currentItem = orderList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount() = orderList.size

    class OrderHistoryViewHolder(private val binding: RecyclerViewOrderhistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: DataOrderHistory) {
            binding.pp.setImageResource(data.imageResId)
            binding.namayangpost.text = data.name
            binding.tanggalorder.text = data.date
            binding.kondisistatusorder.text = data.status

            val statusColor = when (data.status) {
                "Completed" -> R.color.ijokomplit
                "Booked" -> R.color.kuningbooked
                "Cancelled" -> R.color.merahcancel
                else -> R.color.black
            }
            binding.kondisistatusorder.setTextColor(
                binding.kondisistatusorder.context.resources.getColor(statusColor)
            )
        }
    }
}

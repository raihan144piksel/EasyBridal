package com.example.easybridal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class HomeAdapter (private val postlist : ArrayList<datapost>) : RecyclerView.Adapter<HomeAdapter.Myviewholder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myviewholder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.raw_post, parent, false)
        return  Myviewholder(itemView)
    }

    override fun getItemCount(): Int {
        return postlist.size
    }

    override fun onBindViewHolder(holder: Myviewholder, position: Int) {
        val currentitem = postlist[position]
        holder.pp.setImageResource(currentitem.pp)
        holder.potopost.setImageResource(currentitem.potopost)
        holder.namayangpost.text = currentitem.namayangpost
    }

    class Myviewholder(itemview : View) : RecyclerView.ViewHolder(itemview)
    {

        val pp : ShapeableImageView = itemview.findViewById(R.id.pp)
        val potopost : ShapeableImageView = itemview.findViewById(R.id.potopost)
        val namayangpost : TextView = itemview.findViewById(R.id.namayangpost)

    }


}


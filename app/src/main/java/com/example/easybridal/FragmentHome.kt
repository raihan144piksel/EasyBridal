package com.example.easybridal

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentHome : Fragment(), AdapterHome.OnItemClickListener {
    private lateinit var adapter: AdapterHome
    private lateinit var recyclerView: RecyclerView
    private lateinit var productList: ArrayList<Product>
    private var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up the cart icon click listener
        val cartIcon: ImageView = view.findViewById(R.id.keranjang)
        cartIcon.setOnClickListener {
            val intent = Intent(activity, CartMenu::class.java)
            startActivity(intent)
        }

        // Initialize data
        dataInitialize()

        // Set up RecyclerView with GridLayoutManager
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.setHasFixedSize(true)
        adapter = AdapterHome(productList, this)
        recyclerView.adapter = adapter

        navController = Navigation.findNavController(view)
    }

    private fun dataInitialize() {
        // Fetch products from PusatData
        productList = ArrayList(PusatData.products)
    }

    override fun onItemClick(position: Int) {
        val selectedProduct = productList[position]
        val intent = Intent(activity, DetailService::class.java).apply {
            putExtra("title", selectedProduct.title)
            putExtra("price", selectedProduct.price)
            putExtra("description", selectedProduct.description)
            putExtra("vendor", selectedProduct.vendor)
            putIntegerArrayListExtra("pictures", ArrayList(selectedProduct.pictures))
        }
        startActivity(intent)
    }
}

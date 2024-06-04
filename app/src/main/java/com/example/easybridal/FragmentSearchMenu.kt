package com.example.easybridal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentSearchMenu : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    private lateinit var vendorRecyclerView: RecyclerView
    private lateinit var vendorAdapter: VendorAdapter
    private lateinit var vendorList: ArrayList<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)

        // Initialize data
        dataInitialize()

        // Set up vendor RecyclerView with GridLayoutManager for vertical scrolling
        vendorRecyclerView = view.findViewById(R.id.recycler_view_vendor)
        vendorRecyclerView.layoutManager = GridLayoutManager(context, 2)
        vendorRecyclerView.setHasFixedSize(true)
        vendorAdapter = VendorAdapter(vendorList, this)
        vendorRecyclerView.adapter = vendorAdapter

        return view
    }

    private fun dataInitialize() {
        // Fetch products from PusatData
        vendorList = ArrayList(PusatData.products)
    }

    companion object {
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentSearchMenu().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}

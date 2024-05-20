package com.example.easybridal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SearchMenuFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

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

        val feedRecyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_feed)
        val vendorRecyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_vendor)

        val feedList = listOf(
            FeedData(R.drawable.a),
            FeedData(R.drawable.a),
            FeedData(R.drawable.a),
            FeedData(R.drawable.a),
            FeedData(R.drawable.a),
            FeedData(R.drawable.a),
            FeedData(R.drawable.a),
            FeedData(R.drawable.a),
            FeedData(R.drawable.a),
            FeedData(R.drawable.a),
            FeedData(R.drawable.a),
            FeedData(R.drawable.a),
            FeedData(R.drawable.a),
            )

        val vendorList = listOf(
            VendorData(R.drawable.a, "BUNDLING FULL PACKAGE PRE+WEDDING", "by Java Bride - Wedding Planner", "Rp25.000.0000", listOf("Hashtag1", "Hashtag2")),
            VendorData(R.drawable.a, "BUNDLING FULL PACKAGE PRE+WEDDING", "by Java Bride - Wedding Planner", "Rp25.000.0000", listOf("Hashtag3", "Hashtag4")),
            VendorData(R.drawable.a, "BUNDLING FULL PACKAGE PRE+WEDDING", "Vby Java Bride - Wedding Planner", "Rp25.000.0000", listOf("Hashtag5", "Hashtag6")),
            VendorData(R.drawable.a, "BUNDLING FULL PACKAGE PRE+WEDDING", "by Java Bride - Wedding Planner", "Rp25.000.0000", listOf("Hashtag1", "Hashtag2")),
            VendorData(R.drawable.a, "BUNDLING FULL PACKAGE PRE+WEDDING", "by Java Bride - Wedding Planner", "Rp25.000.0000", listOf("Hashtag3", "Hashtag4")),
            VendorData(R.drawable.a, "BUNDLING FULL PACKAGE PRE+WEDDING", "Vby Java Bride - Wedding Planner", "Rp25.000.0000", listOf("Hashtag5", "Hashtag6")),VendorData(R.drawable.a, "BUNDLING FULL PACKAGE PRE+WEDDING", "by Java Bride - Wedding Planner", "Rp25.000.0000", listOf("Hashtag1", "Hashtag2")),
            VendorData(R.drawable.a, "BUNDLING FULL PACKAGE PRE+WEDDING", "by Java Bride - Wedding Planner", "Rp25.000.0000", listOf("Hashtag3", "Hashtag4")),
            VendorData(R.drawable.a, "BUNDLING FULL PACKAGE PRE+WEDDING", "Vby Java Bride - Wedding Planner", "Rp25.000.0000", listOf("Hashtag5", "Hashtag6")),VendorData(R.drawable.a, "BUNDLING FULL PACKAGE PRE+WEDDING", "by Java Bride - Wedding Planner", "Rp25.000.0000", listOf("Hashtag1", "Hashtag2")),
            VendorData(R.drawable.a, "BUNDLING FULL PACKAGE PRE+WEDDING", "by Java Bride - Wedding Planner", "Rp25.000.0000", listOf("Hashtag3", "Hashtag4")),
            VendorData(R.drawable.a, "BUNDLING FULL PACKAGE PRE+WEDDING", "Vby Java Bride - Wedding Planner", "Rp25.000.0000", listOf("Hashtag5", "Hashtag6")),
        )

        // Set up feed RecyclerView with GridLayoutManager for horizontal scrolling
        feedRecyclerView.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.HORIZONTAL, false)
        feedRecyclerView.adapter = FeedAdapter(feedList)

        // Set up vendor RecyclerView with GridLayoutManager for vertical scrolling
        vendorRecyclerView.layoutManager = GridLayoutManager(context, 2)
        vendorRecyclerView.adapter = VendorAdapter(vendorList)

        return view
    }

    companion object {
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchMenuFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}

package com.example.easybridal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class OrderHistoryFragment : Fragment() {

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
        val view = inflater.inflate(R.layout.fragment_orderhistory, container, false)

        val orderList = listOf(
            DataOrderHistory(R.drawable.baseline_account_circle_24, "Java Bride", "20/8/2030", "Completed"),
            DataOrderHistory(R.drawable.baseline_account_circle_24, "Java Bride1", "21/8/2030", "Booked"),
            DataOrderHistory(R.drawable.baseline_account_circle_24, "Java Bride2", "22/8/2030", "Cancelled"),
            DataOrderHistory(R.drawable.baseline_account_circle_24, "Java Bride3", "22/8/2030", "Booked"),
            DataOrderHistory(R.drawable.baseline_account_circle_24, "Java Bride4", "22/8/2030", "Completed"),
            DataOrderHistory(R.drawable.baseline_account_circle_24, "Java Bride5", "22/8/2030", "Cancelled"),
            DataOrderHistory(R.drawable.baseline_account_circle_24, "Java Bride6", "22/8/2030", "Booked"),
            DataOrderHistory(R.drawable.baseline_account_circle_24, "Java Bride7", "22/8/2030", "Booked"),
            )

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = OrderHistoryAdapter(orderList)

        return view
    }

    companion object {
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OrderHistoryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}

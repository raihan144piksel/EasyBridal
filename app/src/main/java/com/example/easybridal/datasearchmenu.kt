package com.example.easybridal

data class FeedData(
    val imageResId: Int
)

data class VendorData(
    val imageResId: Int,
    val title: String,
    val vendorName: String,
    val price: String,
    val hashtags: List<String>
)

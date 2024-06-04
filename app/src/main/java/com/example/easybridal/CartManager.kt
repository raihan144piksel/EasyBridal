package com.example.easybridal

object CartManager {
    private val cartItems = mutableListOf<CartItem>()

    fun addItem(item: CartItem) {
        cartItems.add(item)
    }

    fun getItems(): List<CartItem> {
        return cartItems
    }

    fun clearItems() {
        cartItems.clear()
    }
}

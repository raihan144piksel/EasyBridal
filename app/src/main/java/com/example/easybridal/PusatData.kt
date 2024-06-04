package com.example.easybridal

data class Customer(
    var id: Int,
    var email: String,
    var password: String,
    var name: String,
    var photoProfile: String,
    var phoneNumber: String,
    var cardHolderName: String,
    var cardNumber: String,
    var expiryDate: String,
    var securityCode: String,
    var postalCode: String,
    var country: String,
    var cartItems: List<String>, // List of product/service IDs in the cart
    var groomFirstName: String,
    var groomSurname: String,
    var brideFirstName: String,
    var brideSurname: String,
    var homeLocation: String,
    var weddingLocation: String,
    var weddingDate: String, // Format: YYYY-MM-DD
    var checkoutHistory: List<String> // List of checked out product/service IDs
)

data class ServiceProvider(
    val id: Int,
    var name: String,
    var description: String,
    var photoProfile: Int
)

data class Product(
    var id: Int,
    var title: String,
    var price: Double,
    var description: String,
    var includedItems: List<String>, // List of included items (e.g., venue, photography, etc.)
    var rating: Float,
    var pictures: List<Int>, // List of drawable resource IDs
    var vendor: String,
    var lokasi: String
)

object PusatData {

    val serviceProviders: List<ServiceProvider> = listOf(
        ServiceProvider(
            id = 210,
            name = "Java Bride - Wedding Planner",
            description = "Lorem ipsum dolor sit amet consectetur adipiscing elit Ut et massa mi. Aliquam in hendrerit urna. Pellentesque sit amet sapien.",
            photoProfile = R.drawable.javabride
        ),
        ServiceProvider(
            id = 211,
            name = "Bali Bride - Wedding Planner",
            description = "Bali Bride description here.",
            photoProfile = R.drawable.balibred
        ),
        ServiceProvider(
            id = 212,
            name = "Sumatra Bride - Wedding Planner",
            description = "Sumatra Bride description here.",
            photoProfile = R.drawable.sumatera
        )
    )

    val products: List<Product> = listOf(
        Product(
            id = 1,
            title = "Full Wedding Package",
            price = 25000000.0,
            description = "Complete wedding package including venue, photography, and catering.",
            includedItems = listOf("Venue", "Photography", "Catering"),
            rating = 4.5f,
            pictures = listOf(R.drawable.nikah1),
            vendor = "Java Bride - Wedding Planner",
            lokasi = "Jakarta"
        ),
        Product(
            id = 2,
            title = "Tidak Full Wedding Package",
            price = 25000000.0,
            description = "Complete wedding package including venue, photography, and catering.",
            includedItems = listOf("Venue", "Photography", "Catering"),
            rating = 4.5f,
            pictures = listOf(R.drawable.nikah5),
            vendor = "Java Bride - Wedding Planner",
            lokasi = "Bekasi"
        ),
        Product(
            id = 2,
            title = "Premium Wedding Package",
            price = 30000000.0,
            description = "Premium wedding package including luxury venue, photography, and catering.",
            includedItems = listOf("Luxury Venue", "Photography", "Catering"),
            rating = 4.7f,
            pictures = listOf(R.drawable.nikah2),
            vendor = "Bali Bride - Wedding Planner",
            lokasi = "Denpasar"
        ),
        Product(
            id = 3,
            title = "Regular Wedding Package",
            price = 30000000.0,
            description = "Premium wedding package including luxury venue, photography, and catering.",
            includedItems = listOf("Luxury Venue", "Photography", "Catering"),
            rating = 4.9f,
            pictures = listOf(R.drawable.nikah6),
            vendor = "Bali Bride - Wedding Planner",
            lokasi = "Bali"
        ),
        Product(
            id = 4,
            title = "Exclusive Wedding Package",
            price = 35000000.0,
            description = "Exclusive wedding package including premium venue, photography, and catering.",
            includedItems = listOf("Premium Venue", "Photography", "Catering"),
            rating = 5.0f,
            pictures = listOf(R.drawable.nikah3),
            vendor = "Sumatra Bride - Wedding Planner",
            lokasi = "Aceh"
        ),
        Product(
            id = 5,
            title = "Exclusive Wedding Package",
            price = 35000000.0,
            description = "Exclusive wedding package including premium venue, photography, and catering.",
            includedItems = listOf("Premium Venue", "Photography", "Catering"),
            rating = 5.0f,
            pictures = listOf(R.drawable.nikah4),
            vendor = "Sumatra Bride - Wedding Planner",
            lokasi = "Sumatera Barat"
        )
    )

    private val customers: MutableList<Customer> = mutableListOf()
    private var nextCustomerId: Int = 1

    fun getNextCustomerId(): Int {
        return nextCustomerId++
    }

    fun addCustomer(customer: Customer): Customer {
        customers.add(customer)
        return customer
    }

    fun getCustomerByEmail(email: String): Customer? {
        return customers.find { it.email == email }
    }

    fun getCustomerByEmailAndPassword(email: String, password: String): Customer? {
        return customers.find { it.email == email && it.password == password }
    }


    // Fetch products for a given ServiceProvider
    fun getProductsByServiceProvider(serviceProviderName: String): List<Product> {
        return products.filter { it.vendor == serviceProviderName }
    }

    // Fetch the ServiceProvider for a given product
    fun getServiceProviderByProduct(product: Product): ServiceProvider? {
        return serviceProviders.find { it.name == product.vendor }
    }
}

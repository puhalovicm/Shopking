package hr.fer.objobl.shopking.data.model

data class Article(
    val id: Long,
    val name: String,
    val description: String,
    val price: String,
    val imageUrl: String,
    val isOnSale: Boolean
)

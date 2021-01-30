package hr.fer.objobl.shopking.data.model

data class Recipe(
    val id: Long,
    val name: String,
    val description: String,
    val imageUrl: String,
    val ingredients: List<String>,
    val timeEstimated: Int,
    val totalPrice: String,
    val difficulty: String
)

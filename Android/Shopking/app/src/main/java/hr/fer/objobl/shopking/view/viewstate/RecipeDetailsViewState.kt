package hr.fer.objobl.shopking.view.viewstate

import hr.fer.objobl.shopking.utils.DiffCallbackViewState
import java.io.Serializable

class RecipeDetailsViewState(
    override val id: Long,
    val name: String,
    val imageUrl: String,
    val description: String,
    val ingredients: List<String>,
    val timeEstimated: Int,
    val totalPrice: String,
    val difficulty: String
) : DiffCallbackViewState(id), Serializable

package hr.fer.objobl.shopking.view.viewstate

import hr.fer.objobl.shopking.utils.DiffCallbackViewState

class RecipeViewState(
    override val id: Long,
    val name: String,
    val imageUrl: String,
    val timeEstimated: Int,
    val totalPrice: String,
    val difficulty: String
) : DiffCallbackViewState(id)

package hr.fer.objobl.shopking.view.viewstate

import hr.fer.objobl.shopking.utils.DiffCallbackViewState

data class IngredientViewState(
    val name: String,
    var isOnShoppingList: Boolean,
    var isOnWishList: Boolean
) : DiffCallbackViewState(name)

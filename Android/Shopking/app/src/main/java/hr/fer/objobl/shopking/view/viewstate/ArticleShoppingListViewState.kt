package hr.fer.objobl.shopking.view.viewstate

import hr.fer.objobl.shopking.utils.DiffCallbackViewState

class ArticleShoppingListViewState(
    override val id: Long,
    val name: String,
    val description: String,
    val price: String,
    val imageUrl: String,
    val quantity: Int
) : DiffCallbackViewState(id)

package hr.fer.objobl.shopking.view.viewstate

import hr.fer.objobl.shopking.utils.DiffCallbackViewState

data class CategoryViewState(
    val name: String,
    var isSelected: Boolean
) : DiffCallbackViewState(name)

package hr.fer.objobl.shopking.view.viewstate

import hr.fer.objobl.shopking.utils.DiffCallbackViewState

class ShopViewState(
    override val id: Long,
    val address: String
) : DiffCallbackViewState(id)

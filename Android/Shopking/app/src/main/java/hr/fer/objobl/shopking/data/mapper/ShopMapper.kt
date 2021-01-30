package hr.fer.objobl.shopking.data.mapper

import hr.fer.objobl.shopking.data.model.Shop
import hr.fer.objobl.shopking.view.viewstate.ShopViewState

fun List<Shop>.mapToViewStateList() = this.map { it.mapToViewState() }

private fun Shop.mapToViewState() = ShopViewState(
    id,
    address
)

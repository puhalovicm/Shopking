package hr.fer.objobl.shopking.data.mapper

import hr.fer.objobl.shopking.data.model.Shop
import hr.fer.objobl.shopking.data.model.api.ApiShop
import hr.fer.objobl.shopking.view.viewstate.ShopViewState

fun List<Shop>.mapToViewStateList() = this.map { it.mapToViewState() }

private fun Shop.mapToViewState() = ShopViewState(
    id,
    address
)

fun List<ApiShop>.mapToShopList() = map { it.mapToShop() }

fun ApiShop.mapToShop() = Shop(
    id,
    address
)

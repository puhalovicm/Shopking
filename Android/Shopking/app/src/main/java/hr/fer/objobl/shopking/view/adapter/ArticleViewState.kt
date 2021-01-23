package hr.fer.objobl.shopking.view.adapter

import androidx.annotation.DrawableRes

class ArticleViewState(
    val name: String,
    val description: String,
    val price: String,
    @DrawableRes
    val image: Int,
    val isOnSale: Boolean,
    val isOnWishList: Boolean,
    val isOnShoppingList: Boolean
)

package hr.fer.objobl.shopking.data.mapper

import hr.fer.objobl.shopking.data.model.Article
import hr.fer.objobl.shopking.data.model.db.ShoppingListArticle
import hr.fer.objobl.shopking.data.model.db.WishListArticle
import hr.fer.objobl.shopking.view.viewstate.ArticleDetailsViewState
import hr.fer.objobl.shopking.view.viewstate.ArticleShoppingListViewState
import hr.fer.objobl.shopking.view.viewstate.ArticleViewState
import hr.fer.objobl.shopking.view.viewstate.ArticleWishListViewState

fun List<Article>.mapToViewStateList() = this.map { it.mapToViewState() }

private fun Article.mapToViewState() = ArticleViewState(
    id,
    name,
    company,
    price,
    imageUrl,
    isOnSale,
    false,
    false
)

fun Article.mapToDetailsViewState() = ArticleDetailsViewState(
    name,
    company,
    company,
    price,
    imageUrl
)

fun List<ShoppingListArticle>.mapToShoppingListViewStateList() = this.map { it.mapToShoppingListViewState() }

fun ShoppingListArticle.mapToShoppingListViewState() = ArticleShoppingListViewState(
    id,
    name,
    company,
    price,
    imageUrl,
    1
)

fun List<WishListArticle>.mapToWishListViewStateList() = this.map { it.mapToWishListViewState() }

fun WishListArticle.mapToWishListViewState() = ArticleWishListViewState(
    id,
    name,
    company,
    price,
    imageUrl,
    false
)

package hr.fer.objobl.shopking.data.mapper

import hr.fer.objobl.shopking.data.model.Article
import hr.fer.objobl.shopking.view.viewstate.ArticleViewState

fun List<Article>.mapToViewStateList() = this.map { it.mapToViewState() }

private fun Article.mapToViewState() = ArticleViewState(
    id,
    name,
    description,
    price,
    imageUrl,
    isOnSale,
    false,
    false
)

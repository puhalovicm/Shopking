package hr.fer.objobl.shopking.view.viewstate

import java.io.Serializable

class ArticleDetailsViewState(
    val name: String,
    val company: String,
    val mass: String,
    val price: String,
    val imageUrl: String
) : Serializable

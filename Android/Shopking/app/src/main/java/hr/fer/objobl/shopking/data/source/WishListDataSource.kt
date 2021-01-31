package hr.fer.objobl.shopking.data.source

import hr.fer.objobl.shopking.data.db.ShopkingDatabase
import hr.fer.objobl.shopking.data.model.db.WishListArticle

class WishListDataSource(
    private val database: ShopkingDatabase,
) {

    val articles = database.wishListDao().getAll()

    fun addItem(article: WishListArticle) {
        database.wishListDao().insertAll(article)
    }
}

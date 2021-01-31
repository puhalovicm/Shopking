package hr.fer.objobl.shopking.data.source

import hr.fer.objobl.shopking.data.db.ShopkingDatabase
import hr.fer.objobl.shopking.data.model.db.ShoppingListArticle

class ShoppingListDataSource(
    private val database: ShopkingDatabase
) {

    val articles = database.shoppingListDao().getAll()

    fun addItem(article: ShoppingListArticle) {
        database.shoppingListDao().insertAll(article)
    }
}

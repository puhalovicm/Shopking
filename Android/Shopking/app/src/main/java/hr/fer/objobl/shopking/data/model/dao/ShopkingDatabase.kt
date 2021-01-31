package hr.fer.objobl.shopking.data.model.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import hr.fer.objobl.shopking.data.model.db.ShoppingListArticle
import hr.fer.objobl.shopking.data.model.db.WishListArticle

@Database(entities = [ShoppingListArticle::class, WishListArticle::class], version = 1)
abstract class ShopkingDatabase : RoomDatabase() {

    abstract fun shoppingListDao(): ShoppingListDao

    abstract fun wishListDao(): WishListDao
}

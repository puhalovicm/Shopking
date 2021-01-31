package hr.fer.objobl.shopking.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import hr.fer.objobl.shopking.data.model.db.ShoppingListArticle

@Dao
interface ShoppingListDao {

    @Query("SELECT * FROM shopping_list")
    fun getAll(): LiveData<List<ShoppingListArticle>>

    @Insert
    fun insertAll(vararg users: ShoppingListArticle)

    @Update
    fun update(vararg users: ShoppingListArticle)

    @Delete
    fun delete(article: ShoppingListArticle)
}

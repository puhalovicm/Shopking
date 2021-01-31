package hr.fer.objobl.shopking.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import hr.fer.objobl.shopking.data.model.db.WishListArticle

@Dao
interface WishListDao {

    @Query("SELECT * FROM wish_list")
    fun getAll(): LiveData<List<WishListArticle>>

    @Insert
    fun insertAll(vararg users: WishListArticle)

    @Update
    fun update(vararg users: WishListArticle)

    @Delete
    fun delete(article: WishListArticle)
}

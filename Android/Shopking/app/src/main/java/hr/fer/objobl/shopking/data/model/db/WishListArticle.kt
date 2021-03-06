package hr.fer.objobl.shopking.data.model.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wish_list")
data class WishListArticle(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "company") val company: String,
    @ColumnInfo(name = "price") val price: String,
    @ColumnInfo(name = "image_url") val imageUrl: String
)

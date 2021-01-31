package hr.fer.objobl.shopking.data.source

import androidx.lifecycle.MutableLiveData
import hr.fer.objobl.shopking.data.mapper.mapToArticle
import hr.fer.objobl.shopking.data.mapper.mapToArticleList
import hr.fer.objobl.shopking.data.mapper.mapToShoppingList
import hr.fer.objobl.shopking.data.mapper.mapToWishList
import hr.fer.objobl.shopking.data.model.Article
import hr.fer.objobl.shopking.data.model.api.ApiItem
import hr.fer.objobl.shopking.data.model.api.ItemsService
import hr.fer.objobl.shopking.data.model.db.ShoppingListArticle
import hr.fer.objobl.shopking.data.model.db.WishListArticle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticleDataSource(
    private val itemsService: ItemsService
) {

    val articles: MutableLiveData<List<Article>> = MutableLiveData()

    fun fetchItems() {
        itemsService.getItems().enqueue(object : Callback<List<ApiItem>> {

            override fun onResponse(call: Call<List<ApiItem>>, response: Response<List<ApiItem>>) {
                if (response.isSuccessful) {
                    articles.postValue(response.body()?.mapToArticleList())
                }
            }

            override fun onFailure(call: Call<List<ApiItem>>, t: Throwable) {}
        })
    }

    fun fetchItems(category: String) {
        itemsService.getItemsByCategory(category).enqueue(object : Callback<List<ApiItem>> {

            override fun onResponse(call: Call<List<ApiItem>>, response: Response<List<ApiItem>>) {
                if (response.isSuccessful) {
                    articles.postValue(response.body()?.mapToArticleList())
                }
            }

            override fun onFailure(call: Call<List<ApiItem>>, t: Throwable) {}
        })
    }

    fun fetchItemForShoppingList(id: Long, onResponseAction: (ShoppingListArticle) -> Unit) {
        itemsService.getItemById(id).enqueue(object : Callback<ApiItem> {

            override fun onResponse(call: Call<ApiItem>, response: Response<ApiItem>) {
                if (response.isSuccessful) {
                    response.body()?.let { onResponseAction(it.mapToShoppingList()) }
                }
            }

            override fun onFailure(call: Call<ApiItem>, t: Throwable) {}
        })
    }

    fun fetchItemForWishList(id: Long, onResponseAction: (WishListArticle) -> Unit) {
        itemsService.getItemById(id).enqueue(object : Callback<ApiItem> {

            override fun onResponse(call: Call<ApiItem>, response: Response<ApiItem>) {
                if (response.isSuccessful) {
                    response.body()?.let { onResponseAction(it.mapToWishList()) }
                }
            }

            override fun onFailure(call: Call<ApiItem>, t: Throwable) {}
        })
    }
}

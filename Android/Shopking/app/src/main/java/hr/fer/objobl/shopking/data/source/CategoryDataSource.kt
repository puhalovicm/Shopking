package hr.fer.objobl.shopking.data.source

import androidx.lifecycle.MutableLiveData
import hr.fer.objobl.shopking.data.mapper.mapToArticleList
import hr.fer.objobl.shopking.data.model.Article
import hr.fer.objobl.shopking.data.model.api.ApiItem
import hr.fer.objobl.shopking.data.model.api.ItemsService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryDataSource(
    private val itemsService: ItemsService
) {

    val categories: MutableLiveData<List<String>> = MutableLiveData()

    fun fetchCategories() {
        itemsService.getCategories().enqueue(object : Callback<List<String>> {

            override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
                if (response.isSuccessful) {
                    categories.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<List<String>>, t: Throwable) {}
        })
    }
}

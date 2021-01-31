package hr.fer.objobl.shopking.data.model.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ItemsService {

    @GET("api/items")
    fun getItems(): Call<List<ApiItem>>

    @GET("api/items/categories")
    fun getCategories(): Call<List<String>>

    @GET("api/items/{id}")
    fun getItemById(@Path("id") id: Long): Call<ApiItem>

    @GET("api/items/{category}")
    fun getItemsByCategory(@Path("category") category: String): Call<List<ApiItem>>
}
